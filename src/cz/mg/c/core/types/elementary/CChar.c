#include "../../CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CChar_nativeSize(JNIEnv* env, jclass clazz, jlong address) {
    return sizeof(char);
}

JNIEXPORT jchar JNICALL Java_cz_mg_c_core_types_elementary_CChar_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    char* ptr = (char*) l2p(address);
    return *ptr;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_types_elementary_CChar_nativeSet(JNIEnv* env, jclass clazz, jlong address, jchar ch) {
    char* ptr = (char*) l2p(address);
    *ptr = ch;
}
