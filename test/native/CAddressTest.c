#include "CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getNull(JNIEnv* env, jclass clazz) {
    return a2l(NULL);
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyNull(JNIEnv* env, jclass clazz) {
    return NULL == 0L ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyNull2(JNIEnv* env, jclass clazz, jlong value) {
    return NULL == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

static void* getPointerHalf() {
    void* pointer = NULL;
    return pointer + INT64_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getPointerHalf(JNIEnv* env, jclass clazz) {
    return a2l(getPointerHalf());
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyHalfPlusZero(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() + 0 == l2a(value)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyHalfPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() + 1 == l2a(value)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyHalfMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() - 1 == l2a(value)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyHalfPlusSeven(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() + 7 == l2a(value)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyHalfMinusSeven(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() - 7 == l2a(value)) ? JNI_TRUE : JNI_FALSE;
}
