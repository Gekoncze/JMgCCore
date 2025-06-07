#include "../../CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CFloat_nativeSize(JNIEnv* env, jclass clazz, jlong address) {
    return sizeof(float);
}

JNIEXPORT jbyte JNICALL Java_cz_mg_c_core_types_elementary_CFloat_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    float* ptr = (float*) l2p(address);
    return *ptr;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_types_elementary_CFloat_nativeSet(JNIEnv* env, jclass clazz, jlong address, jfloat value) {
    float* ptr = (float*) l2p(address);
    *ptr = value;
}
