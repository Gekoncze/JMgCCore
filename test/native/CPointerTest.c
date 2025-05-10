#include "CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CPointerTest_getNull(JNIEnv* env, jclass clazz) {
    return p2l(NULL);
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CPointerTest_verifyNull(JNIEnv* env, jclass clazz) {
    return NULL == 0L ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CPointerTest_verifyNull2(JNIEnv* env, jclass clazz, jlong value) {
    return NULL == l2p(value) ? JNI_TRUE : JNI_FALSE;
}

static void* getPointerHalf() {
    void* pointer = NULL;
    return pointer + INT64_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CPointerTest_getPointerHalf(JNIEnv* env, jclass clazz) {
    return p2l(getPointerHalf());
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CPointerTest_verifyHalfPlusZero(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() + 0 == l2p(value)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CPointerTest_verifyHalfPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() + 1 == l2p(value)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CPointerTest_verifyHalfMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() - 1 == l2p(value)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CPointerTest_verifyHalfPlusSeven(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() + 7 == l2p(value)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CPointerTest_verifyHalfMinusSeven(JNIEnv* env, jclass clazz, jlong value) {
    return (getPointerHalf() - 7 == l2p(value)) ? JNI_TRUE : JNI_FALSE;
}
