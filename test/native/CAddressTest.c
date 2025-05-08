#include "CAddress.h"
#include <stdint.h>

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getNull(JNIEnv* env, jclass clazz) {
    return a2l(NULL);
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyNull(JNIEnv* env, jclass clazz) {
    return NULL == 0L ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyNull2(JNIEnv* env, jclass clazz, jlong value) {
    return NULL == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

void* getPointerMin() {
    void* pointer = NULL;
    return pointer;
}

void* getPointerMinPlusOne() {
    void* pointer = NULL;
    return pointer + 1;
}

void* getPointerHalfMinusOne() {
    void* pointer = NULL;
    pointer += INT64_MAX;
    return pointer - 1;
}

void* getPointerHalf() {
    void* pointer = NULL;
    return pointer + INT64_MAX;
}

void* getPointerHalfPlusOne() {
    void* pointer = NULL;
    pointer += INT64_MAX;
    return pointer + 1;
}

void* getPointerMaxMinusOne() {
    void* pointer = NULL;
    pointer += UINT64_MAX;
    return pointer - 1;
}

void* getPointerMax() {
    void* pointer = NULL;
    return pointer + UINT64_MAX;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getPointerMin(JNIEnv* env, jclass clazz) {
    return a2l(getPointerMin());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getPointerMinPlusOne(JNIEnv* env, jclass clazz) {
    return a2l(getPointerMinPlusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getPointerHalfMinusOne(JNIEnv* env, jclass clazz) {
    return a2l(getPointerHalfMinusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getPointerHalf(JNIEnv* env, jclass clazz) {
    return a2l(getPointerHalf());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getPointerHalfPlusOne(JNIEnv* env, jclass clazz) {
    return a2l(getPointerHalfPlusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getPointerMaxMinusOne(JNIEnv* env, jclass clazz) {
    return a2l(getPointerMaxMinusOne());
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddressTest_getPointerMax(JNIEnv* env, jclass clazz) {
    return a2l(getPointerMax());
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyPointerMin(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMin() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyPointerMinPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMinPlusOne() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyPointerHalfMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalfMinusOne() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyPointerHalf(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalf() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyPointerHalfPlusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerHalfPlusOne() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyPointerMaxMinusOne(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMaxMinusOne() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jboolean JNICALL Java_cz_mg_c_core_common_CAddressTest_verifyPointerMax(JNIEnv* env, jclass clazz, jlong value) {
    return getPointerMax() == l2a(value) ? JNI_TRUE : JNI_FALSE;
}