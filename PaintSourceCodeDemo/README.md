# Paint源代码解析

## Paint构造方法

- 无参构造方法Paint()

使用默认的设置创建一个paint。

```java
public Paint() {
	//调用有参构造方法Paint(int flags)，flags=0
    this(0);
}
```

默认设置是flags=0，调用有参构造方法Paint(int flags)：

```java
public Paint(int flags) {
	//初始化本地paint长度
    mNativePaint = nInit();
    //使用无图占位注册本地内存分配
    NoImagePreloadHolder.sRegistry.registerNativeAllocation(this, mNativePaint);
    //设置paint的flag，使用flag枚举指定flag的值
    setFlags(flags | HIDDEN_DEFAULT_PAINT_FLAGS);
    //
    mCompatScaling = mInvCompatScaling = 1;
    //设置文本区域列表
    setTextLocales(LocaleList.getAdjustedDefault());
}
```

设置flag方法：

```java
//
public void setFlags(int flags) {
    nSetFlags(mNativePaint, flags);
}
//调用native方法
private native void nSetFlags(long paintPtr, int flags);
```

设置文本区域列表，文本区域列表会影响文本对某些语言的绘制：

```java
public void setTextLocales(@NonNull @Size(min=1) LocaleList locales) {
    if (locales == null || locales.isEmpty()) {
        throw new IllegalArgumentException("locales cannot be null or empty");
    }
    if (locales.equals(mLocales)) return;
    mLocales = locales;
    syncTextLocalesWithMinikin();
}
```

同步本地文本通过Minikin语言：

```java
private void syncTextLocalesWithMinikin() {
    final String languageTags = mLocales.toLanguageTags();
    final Integer minikinLangListId;
    synchronized (sCacheLock) {
        minikinLangListId = sMinikinLangListIdCache.get(languageTags);
        if (minikinLangListId == null) {
            final int newID = nSetTextLocales(mNativePaint, languageTags);
            sMinikinLangListIdCache.put(languageTags, newID);
            return;
        }
    }
    nSetTextLocalesByMinikinLangListId(mNativePaint, minikinLangListId.intValue());
}
```

调用本地方法：

```java
private static native void nSetTextLocalesByMinikinLangListId(long paintPtr,
            int mMinikinLangListId);
```

- 有参构造方法Paint(int flags)

使用特殊的标志创建一个paint。

- 有参构造方法Paint(Paint paint)

创建一个通过paint参数初始化的新的paint。

## Paint重要方法

- ascent()

根据当前的字体和文字大小返回上方（负）基线（上升）的距离。

```java
public float ascent() {
    return nAscent(mNativePaint, mNativeTypeface);
}
private native float nAscent(long paintPtr, long typefacePtr);
```

- breakText(char[] text,int index,int count,float maxWidth,float[] measuredWidth)

测量文本，如果测量的宽度超过maxWidth，则提早停止。返回测量的字符数，如果measuredWidth不为null，则返回测量的实际宽度。

```java
public int breakText(char[] text, int index, int count,
                            float maxWidth, float[] measuredWidth) {
    if (text == null) {
        throw new IllegalArgumentException("text cannot be null");
    }
    if (index < 0 || text.length - index < Math.abs(count)) {
        throw new ArrayIndexOutOfBoundsException();
    }
    if (text.length == 0 || count == 0) {
        return 0;
    }
    if (!mHasCompatScaling) {
        return nBreakText(mNativePaint, mNativeTypeface, text, index, count, maxWidth,
                mBidiFlags, measuredWidth);
    }
    final float oldSize = getTextSize();
    setTextSize(oldSize * mCompatScaling);
    int res = nBreakText(mNativePaint, mNativeTypeface, text, index, count,
            maxWidth * mCompatScaling, mBidiFlags, measuredWidth);
    setTextSize(oldSize);
    if (measuredWidth != null) measuredWidth[0] *= mInvCompatScaling;
    return res;
}
```

- breakText(String text,boolean measureForwards,float maxWidth, float[] measuredWidth)

测量文本，如果测量的宽度超过maxWidth，则提早停止。返回测量的字符数，如果measuredWidth不为null，则返回测量的实际宽度。

```java
public int breakText(String text, boolean measureForwards,
                            float maxWidth, float[] measuredWidth) {
    if (text == null) {
        throw new IllegalArgumentException("text cannot be null");
    }
    if (text.length() == 0) {
        return 0;
    }
    if (!mHasCompatScaling) {
        return nBreakText(mNativePaint, mNativeTypeface, text, measureForwards,
                maxWidth, mBidiFlags, measuredWidth);
    }
    final float oldSize = getTextSize();
    setTextSize(oldSize*mCompatScaling);
    int res = nBreakText(mNativePaint, mNativeTypeface, text, measureForwards,
            maxWidth*mCompatScaling, mBidiFlags, measuredWidth);
    setTextSize(oldSize);
    if (measuredWidth != null) measuredWidth[0] *= mInvCompatScaling;
    return res;
}
```

- breakText(CharSequence text,int start,int end,boolean measureForwards, float maxWidth,float[] measuredWidth)

测量文本，如果测量的宽度超过maxWidth，则提早停止。返回测量的字符数，如果measuredWidth不为null，则返回测量的实际宽度。

```java
public int breakText(CharSequence text, int start, int end,
                     boolean measureForwards,
                     float maxWidth, float[] measuredWidth) {
    if (text == null) {
        throw new IllegalArgumentException("text cannot be null");
    }
    if ((start | end | (end - start) | (text.length() - end)) < 0) {
        throw new IndexOutOfBoundsException();
    }
    if (text.length() == 0 || start == end) {
        return 0;
    }
    if (start == 0 && text instanceof String && end == text.length()) {
        return breakText((String) text, measureForwards, maxWidth,
                         measuredWidth);
    }
    char[] buf = TemporaryBuffer.obtain(end - start);
    int result;
    TextUtils.getChars(text, start, end, buf, 0);
    if (measureForwards) {
        result = breakText(buf, 0, end - start, maxWidth, measuredWidth);
    } else {
        result = breakText(buf, 0, -(end - start), maxWidth, measuredWidth);
    }
    TemporaryBuffer.recycle(buf);
    return result;
}
```

- clearShadowLayer()

清除阴影层

```java
public void clearShadowLayer() {
    setShadowLayer(0, 0, 0, 0);
}

public void setShadowLayer(float radius, float dx, float dy, int shadowColor) {
  nSetShadowLayer(mNativePaint, radius, dx, dy, shadowColor);
}

private static native void nSetShadowLayer(long paintPtr,
            float radius, float dx, float dy, int color);
```

- descent()

根据当前的字体和文字大小，返回下方（正）基线（下降）的距离

```java
public float descent() {
    return nDescent(mNativePaint, mNativeTypeface);
}
private native float nDescent(long paintPtr, long typefacePtr);
```

- getAlpha()

帮助getColor()，只返回颜色的alpha值。它与调用getColor()>>>24相同。它始终返回0（完全透明）和255（完全不透明）之间的值。

```java
public int getAlpha() {
    return nGetAlpha(mNativePaint);
}
private native int nGetAlpha(long paintPtr);
```

- getColor()

油漆的颜色。注意，颜色是一个32位的值，包含alpha和r，g，b。这个32位的值不是预先相乘，这意味着它的alpha值可以是任何值，不管r、g、b的值是多少。更多细节请参见颜色类。

```java
@ColorInt
public int getColor() {
    return nGetColor(mNativePaint);
}
private native int nGetColor(long paintPtr);
```

- getColorFilter()

获取油漆的colorfilter（可能为null）。

```java
public ColorFilter getColorFilter() {
    return mColorFilter;
}
```

- getFillPath(Path src,Path dst)

将任何/全部效果（patheffect，抚摸）应用于src，将结果返回到dst。结果是，绘制src与这个绘画将与绘制dst与默认绘画（至少从几何角度）相同。

```java
public boolean getFillPath(Path src, Path dst) {
        return nGetFillPath(mNativePaint, src.readOnlyNI(), dst.mutateNI());
    }
```

- getFlags()

返回油漆的旗帜。使用标志枚举来测试标志值。

```java
public int getFlags() {
    return nGetFlags(mNativePaint);
}
private native int nGetFlags(long paintPtr);
```

- getFontFeatureSettings()

返回字体功能设置

```java
public String getFontFeatureSettings() {
    return mFontFeatureSettings;
}
```

- getFontMetrics(Paint.FontMetrics metrics)

返回字体的推荐行间距，给出Paint的设置为fontface，textSize等。如果metrics不为null，返回其中的fontmetric值。

```java
public float getFontMetrics(FontMetrics metrics) {
        return nGetFontMetrics(mNativePaint, mNativeTypeface, metrics);
    }

    private native float nGetFontMetrics(long paintPtr,
            long typefacePtr, FontMetrics metrics);
```

- getFontMetrics()

分配一个新的FontMetrics对象，然后调用getFontMetrics(fm)，返回该对象。

```java
public FontMetrics getFontMetrics() {
    FontMetrics fm = new FontMetrics();
    getFontMetrics(fm);
    return fm;
}
```

- getFontMetricsInt(Paint.FontMetricsInt fmi)

返回字体的行间距，给出Paint的字体设置，textSize等。

```java
public int getFontMetricsInt(FontMetricsInt fmi) {
        return nGetFontMetricsInt(mNativePaint, mNativeTypeface, fmi);
    }

    private native int nGetFontMetricsInt(long paintPtr,
            long typefacePtr, FontMetricsInt fmi);
```

- getFontMetricsInt()



```java
public FontMetricsInt getFontMetricsInt() {
    FontMetricsInt fm = new FontMetricsInt();
    getFontMetricsInt(fm);
    return fm;
}
```

- getFontSpacing()

根据当前的字体和文字大小返回推荐行间距。

```java
public float getFontSpacing() {
    return getFontMetrics(null);
}
```

- getFontVariationSettings()

返回字体变体设置。

```java

```

- getHinting()

返回油漆的提示模式。返回HINTING_OFF或HINTING_ON。

```java
public int getHinting() {
    return nGetHinting(mNativePaint);
}
private native int nGetHinting(long paintPtr);
```

- getLetterSpacing()

返回油漆的文字间距。默认值为0。

```java
public float getLetterSpacing() {
    return nGetLetterSpacing(mNativePaint);
}
```

- getMaskFilter()

获得油漆的面具过滤器对象。

```java
public MaskFilter getMaskFilter() {
    return mMaskFilter;
}
```

- getOffsetForAdvance (char[] text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                boolean isRtl, 
                float advance)
                
获取位置最接近指定水平位置的字符串中的字符偏移量。

```java
public int getOffsetForAdvance(char[] text, int start, int end, int contextStart,
        int contextEnd, boolean isRtl, float advance) {
    if (text == null) {
        throw new IllegalArgumentException("text cannot be null");
    }
    if ((contextStart | start | end | contextEnd
            | start - contextStart | end - start | contextEnd - end
            | text.length - contextEnd) < 0) {
        throw new IndexOutOfBoundsException();
    }
    // TODO: take mCompatScaling into account (or eliminate compat scaling)?
    return nGetOffsetForAdvance(mNativePaint, mNativeTypeface, text, start, end,
            contextStart, contextEnd, isRtl, advance);
}
```

- getOffsetForAdvance (CharSequence text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                boolean isRtl, 
                float advance)
                
获取位置最接近指定水平位置的字符串中的字符偏移量。

```java
public int getOffsetForAdvance(CharSequence text, int start, int end, int contextStart,
        int contextEnd, boolean isRtl, float advance) {
    if (text == null) {
        throw new IllegalArgumentException("text cannot be null");
    }
    if ((contextStart | start | end | contextEnd
            | start - contextStart | end - start | contextEnd - end
            | text.length() - contextEnd) < 0) {
        throw new IndexOutOfBoundsException();
    }
    // TODO performance: specialized alternatives to avoid buffer copy, if win is significant
    char[] buf = TemporaryBuffer.obtain(contextEnd - contextStart);
    TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
    int result = getOffsetForAdvance(buf, start - contextStart, end - contextStart, 0,
            contextEnd - contextStart, isRtl, advance) + contextStart;
    TemporaryBuffer.recycle(buf);
    return result;
}
```

- getPathEffect()

获取油漆的patheffect对象。

```java
 public PathEffect getPathEffect() {
     return mPathEffect;
 }
```

- getRunAdvance (char[] text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                boolean isRtl, 
                int offset)
                
在文本运行中测量光标位置。

```java
public float getRunAdvance(char[] text, int start, int end, int contextStart, int contextEnd,
        boolean isRtl, int offset) {
    if (text == null) {
        throw new IllegalArgumentException("text cannot be null");
    }
    if ((contextStart | start | offset | end | contextEnd
            | start - contextStart | offset - start | end - offset
            | contextEnd - end | text.length - contextEnd) < 0) {
        throw new IndexOutOfBoundsException();
    }
    if (end == start) {
        return 0.0f;
    }
    // TODO: take mCompatScaling into account (or eliminate compat scaling)?
    return nGetRunAdvance(mNativePaint, mNativeTypeface, text, start, end,
            contextStart, contextEnd, isRtl, offset);
}
```

- getRunAdvance (CharSequence text, 
                int start, 
                int end, 
                int contextStart, 
                int contextEnd, 
                boolean isRtl, 
                int offset)
                


```java
public float getRunAdvance(CharSequence text, int start, int end, int contextStart,
        int contextEnd, boolean isRtl, int offset) {
    if (text == null) {
        throw new IllegalArgumentException("text cannot be null");
    }
    if ((contextStart | start | offset | end | contextEnd
            | start - contextStart | offset - start | end - offset
            | contextEnd - end | text.length() - contextEnd) < 0) {
        throw new IndexOutOfBoundsException();
    }
    if (end == start) {
        return 0.0f;
    }
    // TODO performance: specialized alternatives to avoid buffer copy, if win is significant
    char[] buf = TemporaryBuffer.obtain(contextEnd - contextStart);
    TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
    float result = getRunAdvance(buf, start - contextStart, end - contextStart, 0,
            contextEnd - contextStart, isRtl, offset - contextStart);
    TemporaryBuffer.recycle(buf);
    return result;
}
```

- getShader()

获取油漆的着色器对象。

```java
public Shader getShader() {
    return mShader;
}
```

- getStrokeCap()

返回油漆的盖帽，控制如何处理划线和路径的开始和结束。

```java
public Cap getStrokeCap() {
        return sCapArray[nGetStrokeCap(mNativePaint)];
    }
```


                
              













