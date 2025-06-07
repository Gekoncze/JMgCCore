#include "../../CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_types_elementary_CDouble_nativeSize(JNIEnv* env, jclass clazz, jlong address) {
    return sizeof(double);
}

JNIEXPORT jbyte JNICALL Java_cz_mg_c_core_types_elementary_CDouble_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    double* ptr = (double*) l2p(address);
    return *ptr;
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_types_elementary_CDouble_nativeSet(JNIEnv* env, jclass clazz, jlong address, jdouble value) {
    double* ptr = (double*) l2p(address);
    *ptr = value;
}
