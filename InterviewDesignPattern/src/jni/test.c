#include "com_dyx_ip_jni_JniTest.h"
#include <stdio.h>

JNIEXPORT jstring JNICALL Java_com_dyx_ip_jni_JniTest_get(JNIEnv *env,jobject job){
    printf("invoke get in C\n");
    return env->NewStringUTF(env,"Hello from JNI!");
}

JNIEXPORT jstring JNICALL Java_com_dyx_ip_jni_JniTest_set(JNIEnv *env,jobject job,jstring msg){
    printf("invoke get in C\n");
    char* str = (char*)(*env)->GetStringUTFChars(env,msg,NULL);
    printf("%s\n",str);
    env->ReleaseStringUTFChars(env,msg,str);
}