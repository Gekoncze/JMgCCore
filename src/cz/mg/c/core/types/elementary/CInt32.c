#include "../../CConvert.h"

JNIEXPORT jint JNICALL Java_cz_mg_c_core_types_elementary_CInt32_nativeMin(JNIEnv* env, jclass clazz) {
    return INT32_MIN;
}

JNIEXPORT jint JNICALL Java_cz_mg_c_core_types_elementary_CInt32_nativeMax(JNIEnv* env, jclass clazz) {
    return INT32_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CInt32_nativeSize(JNIEnv* env, jclass clazz, jlong address) {
    return sizeof(int32_t);
}

JNIEXPORT jint JNICALL Java_cz_mg_c_core_types_elementary_CInt32_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    int32_t* ptr = (int32_t*) l2p(address);
    return *ptr;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_types_elementary_CInt32_nativeSet(JNIEnv* env, jclass clazz, jlong address, jint value) {
    int32_t* ptr = (int32_t*) l2p(address);
    *ptr = value;
}
