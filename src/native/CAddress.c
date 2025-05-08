#include "CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddress_plus(JNIEnv* env, jclass clazz, jlong address, jlong delta) {
    return a2l(l2a(address) + delta);
}
