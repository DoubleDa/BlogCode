package com.dyx.pcl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import dalvik.system.DexClassLoader;

/**
 * project name：PluginClassLoader
 * class describe：自定义classloader
 * create person：dayongxin
 * create time：2017/7/5 上午9:55
 * alter person：dayongxin
 * alter time：2017/7/5 上午9:55
 * alter remark：
 */
public class CustomClassLoader extends DexClassLoader {
    /**
     * 构造方法
     *
     * @param dexPath
     * @param optimizedDirectory
     * @param librarySearchPath
     * @param parent
     */
    public CustomClassLoader(String dexPath, String optimizedDirectory, String librarySearchPath, ClassLoader parent) {
        super(dexPath, optimizedDirectory, librarySearchPath, parent);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData != null) {
            return defineClass(name, classData, 0, classData.length);
        } else {
            throw new ClassNotFoundException();
        }
    }

    private byte[] getClassData(String name) {
        try {
            InputStream is = new FileInputStream(name);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] bytes = new byte[bufferSize];
            int startReadIndex = -1;
            while ((startReadIndex = is.read(bytes)) != -1) {
                baos.write(bytes, 0, startReadIndex);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
