#include "CConvert.h"

static void* getPointerMin() {
    void* pointer = NULL;
    return pointer;
}

static void* getPointerMinPlusOne() {
    void* pointer = NULL;
    return pointer + 1;
}

static void* getPointerHalfMinusOne() {
    void* pointer = NULL;
    pointer += INT64_MAX;
    return pointer - 1;
}

static void* getPointerHalf() {
    void* pointer = NULL;
    return pointer + INT64_MAX;
}

static void* getPointerHalfPlusOne() {
    void* pointer = NULL;
    pointer += INT64_MAX;
    return pointer + 1;
}

static void* getPointerMaxMinusOne() {
    void* pointer = NULL;
    pointer += UINT64_MAX;
    return pointer - 1;
}

static void* getPointerMax() {
    void* pointer = NULL;
    return pointer + UINT64_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerMin(JNIEnv* env, jclass clazz) {
    return a2l(getPointerMin());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerMinPlusOne(JNIEnv* env, jclass clazz) {
    return a2l(getPointerMinPlusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerHalfMinusOne(JNIEnv* env, jclass clazz) {
    return a2l(getPointerHalfMinusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerHalf(JNIEnv* env, jclass clazz) {
    return a2l(getPointerHalf());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerHalfPlusOne(JNIEnv* env, jclass clazz) {
    return a2l(getPointerHalfPlusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerMaxMinusOne(JNIEnv* env, jclass clazz) {
    return a2l(getPointerMaxMinusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerMax(JNIEnv* env, jclass clazz) {
    return a2l(getPointerMax());
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerMin(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMin() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerMinPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMinPlusOne() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerHalfMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalfMinusOne() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerHalf(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalf() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerHalfPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalfPlusOne() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerMaxMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMaxMinusOne() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerMax(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMax() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyAddressSize(JNIEnv* env, jclass clazz) {
    return sizeof(void*) == sizeof(jlong) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeSize(JNIEnv* env, jclass clazz) {
    return sizeof(size_t) == sizeof(jlong) ? JNI_TRUE : JNI_FALSE;
}
