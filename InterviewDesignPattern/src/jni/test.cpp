#include "com_dyx_ip_jni_JniTest.h"
#include <stdio.h>

JNIEXPORT jstring JNICALL Java_com_dyx_ip_jni_JniTest_get(JNIEnv *env,jobject job){
    printf("invoke get in c++\n");
    return env->NewStringUTF("Hello from JNI!");
}

JNIEXPORT jstring JNICALL Java_com_dyx_ip_jni_JniTest_set(JNIEnv *env,jobject job,jstring msg){
    printf("invoke get in c++\n");
    char* str = (char*)env->GetStringUTFChars(msg,NULL);
    printf("%s\n",str);
    env->ReleaseStringUTFChars(msg,str);
}