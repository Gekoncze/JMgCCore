#include "CConvert.h"

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerSize(JNIEnv* env, jclass clazz) {
    return sizeof(void*) == sizeof(jlong) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeSize(JNIEnv* env, jclass clazz) {
    return sizeof(size_t) == sizeof(jlong) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyJLongSize(JNIEnv* env, jclass clazz) {
    return sizeof(jlong) == 8 ? JNI_TRUE : JNI_FALSE;
}

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
    return p2l(getPointerMin());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerMinPlusOne(JNIEnv* env, jclass clazz) {
    return p2l(getPointerMinPlusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerHalfMinusOne(JNIEnv* env, jclass clazz) {
    return p2l(getPointerHalfMinusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerHalf(JNIEnv* env, jclass clazz) {
    return p2l(getPointerHalf());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerHalfPlusOne(JNIEnv* env, jclass clazz) {
    return p2l(getPointerHalfPlusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerMaxMinusOne(JNIEnv* env, jclass clazz) {
    return p2l(getPointerMaxMinusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getPointerMax(JNIEnv* env, jclass clazz) {
    return p2l(getPointerMax());
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerMin(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMin() == l2p(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerMinPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMinPlusOne() == l2p(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerHalfMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalfMinusOne() == l2p(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerHalf(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalf() == l2p(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerHalfPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalfPlusOne() == l2p(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerMaxMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMaxMinusOne() == l2p(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyPointerMax(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMax() == l2p(value) ? JNI_TRUE : JNI_FALSE;
}

static size_t getSizeMin() {
    size_t size = 0L;
    return size;
}

static size_t getSizeMinPlusOne() {
    size_t size = 0L;
    return size + 1;
}

static size_t getSizeHalfMinusOne() {
    size_t size = 0L;
    size += INT64_MAX;
    return size - 1;
}

static size_t getSizeHalf() {
    size_t size = 0L;
    return size + INT64_MAX;
}

static size_t getSizeHalfPlusOne() {
    size_t size = 0L;
    size += INT64_MAX;
    return size + 1;
}

static size_t getSizeMaxMinusOne() {
    size_t size = 0L;
    size += UINT64_MAX;
    return size - 1;
}

static size_t getSizeMax() {
    size_t size = 0L;
    return size + UINT64_MAX;
}

static jlong getLongMin() {
    return INT64_MIN;
}

static jlong getLongMinusOne() {
    return -1L;
}

static jlong getLongZero() {
    return 0L;
}

static jlong getLongOne() {
    return 1L;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getSizeMin(JNIEnv* env, jclass clazz) {
    return s2l(getSizeMin(), env);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getSizeMinPlusOne(JNIEnv* env, jclass clazz) {
    return s2l(getSizeMinPlusOne(), env);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getSizeHalfMinusOne(JNIEnv* env, jclass clazz) {
    return s2l(getSizeHalfMinusOne(), env);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getSizeHalf(JNIEnv* env, jclass clazz) {
    return s2l(getSizeHalf(), env);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getSizeHalfPlusOne(JNIEnv* env, jclass clazz) {
    return s2l(getSizeHalfPlusOne(), env);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getSizeMaxMinusOne(JNIEnv* env, jclass clazz) {
    return s2l(getSizeMaxMinusOne(), env);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CConvertTest_getSizeMax(JNIEnv* env, jclass clazz) {
    return s2l(getSizeMax(), env);
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeMin(JNIEnv* env, jclass clazz, jlong value) {
    return getSizeMin() == l2s(value, env) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeMinPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getSizeMinPlusOne() == l2s(value, env) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeHalfMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getSizeHalfMinusOne() == l2s(value, env) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeHalf(JNIEnv* env, jclass clazz, jlong value) {
    return getSizeHalf() == l2s(value, env) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeHalfPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getSizeHalfPlusOne() == l2s(value, env) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeMaxMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getSizeMaxMinusOne() == l2s(value, env) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CConvertTest_verifySizeMax(JNIEnv* env, jclass clazz, jlong value) {
    return getSizeMax() == l2s(value, env) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyLongMin(JNIEnv* env, jclass clazz) {
    l2s(getLongMin(), env);
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyLongMinusOne(JNIEnv* env, jclass clazz) {
    l2s(getLongMinusOne(), env);
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyLongZero(JNIEnv* env, jclass clazz) {
    l2s(getLongZero(), env);
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_common_CConvertTest_verifyLongOne(JNIEnv* env, jclass clazz) {
    l2s(getLongOne(), env);
}
