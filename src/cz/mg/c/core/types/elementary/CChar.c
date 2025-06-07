#include "../../CConvert.h"

JNIEXPORT jbyte JNICALL Java_cz_mg_c_core_types_elementary_CChar_nativeMin(JNIEnv* env, jclass clazz) {
    return CHAR_MIN;
}

JNIEXPORT jbyte JNICALL Java_cz_mg_c_core_types_elementary_CChar_nativeMax(JNIEnv* env, jclass clazz) {
    return CHAR_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CChar_nativeSize(JNIEnv* env, jclass clazz, jlong address) {
    return sizeof(char);
}

JNIEXPORT jbyte JNICALL Java_cz_mg_c_core_types_elementary_CChar_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    char* ptr = (char*) l2p(address);
    return *ptr;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_types_elementary_CChar_nativeSet(JNIEnv* env, jclass clazz, jlong address, jbyte byte) {
    char* ptr = (char*) l2p(address);
    *ptr = byte;
}
