#include "../../CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CInt64_nativeMin(JNIEnv* env, jclass clazz) {
    return INT64_MIN;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CInt64_nativeMax(JNIEnv* env, jclass clazz) {
    return INT64_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CInt64_nativeSize(JNIEnv* env, jclass clazz, jlong address) {
    return sizeof(int64_t);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CInt64_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    int64_t* ptr = (int64_t*) l2p(address);
    return *ptr;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_types_elementary_CInt64_nativeSet(JNIEnv* env, jclass clazz, jlong address, jlong value) {
    int64_t* ptr = (int64_t*) l2p(address);
    *ptr = value;
}
