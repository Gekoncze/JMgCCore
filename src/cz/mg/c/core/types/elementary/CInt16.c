#include "../../CConvert.h"

JNIEXPORT jshort JNICALL Java_cz_mg_c_core_types_elementary_CInt16_nativeMin(JNIEnv* env, jclass clazz) {
    return INT16_MIN;
}

JNIEXPORT jshort JNICALL Java_cz_mg_c_core_types_elementary_CInt16_nativeMax(JNIEnv* env, jclass clazz) {
    return INT16_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CInt16_nativeSize(JNIEnv* env, jclass clazz, jlong address) {
    return sizeof(int16_t);
}

JNIEXPORT jshort JNICALL Java_cz_mg_c_core_types_elementary_CInt16_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    int16_t* ptr = (int16_t*) l2p(address);
    return *ptr;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_types_elementary_CInt16_nativeSet(JNIEnv* env, jclass clazz, jlong address, jshort value) {
    int16_t* ptr = (int16_t*) l2p(address);
    *ptr = value;
}
