#include "../../CConvert.h"

JNIEXPORT jbyte JNICALL Java_cz_mg_c_core_types_elementary_CInt8_nativeMin(JNIEnv* env, jclass clazz) {
    return INT8_MIN;
}

JNIEXPORT jbyte JNICALL Java_cz_mg_c_core_types_elementary_CInt8_nativeMax(JNIEnv* env, jclass clazz) {
    return INT8_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CInt8_nativeSize(JNIEnv* env, jclass clazz, jlong address) {
    return sizeof(int8_t);
}

JNIEXPORT jbyte JNICALL Java_cz_mg_c_core_types_elementary_CInt8_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    int8_t* ptr = (int8_t*) l2p(address);
    return *ptr;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_types_elementary_CInt8_nativeSet(JNIEnv* env, jclass clazz, jlong address, jbyte byte) {
    int8_t* ptr = (int8_t*) l2p(address);
    *ptr = byte;
}
