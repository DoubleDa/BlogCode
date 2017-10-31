//
// Created by 哒哒 on 2017/10/31.
//

#include "myJniHeader.h"
#include <stdio.h>
#include <stdlib.h>
#include <android/log.h>

#define   LOG_TAG    "MainActivityJni"
#define   LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)


JNIEXPORT void JNICALL Java_com_dyx_ajnp_MainActivity_setText
        (JNIEnv *env, jclass jcl, jstring msg) {
    char *str = (char *) (*env)->GetStringUTFChars(env, msg, NULL);
    LOGI("%s", str);
    (*env)->ReleaseStringUTFChars(env, msg, str);
}

JNIEXPORT jstring JNICALL Java_com_dyx_ajnp_MainActivity_getText
        (JNIEnv *env, jclass jcl) {
    return (*env)->NewStringUTF(env, "Hello Jni!");
}