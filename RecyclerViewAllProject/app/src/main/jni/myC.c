//
// Created by 哒哒 on 2017/10/31.
//

#include "myJni.h"



JNIEXPORT jstring JNICALL Java_com_dyx_rvap_MainActivity_getMsg
        (JNIEnv * env, jclass jcl){
    return (*env)->NewStringUTF(env, "hello JNI，I'm coming");
}