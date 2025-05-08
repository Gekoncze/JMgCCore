#include "CAddress.h"
#include <stdlib.h>

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CMemory_allocate(JNIEnv* env, jclass clazz, jlong size) {
    return a2l(calloc(1, size));
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_common_CMemory_free(JNIEnv* env, jclass clazz, jlong address) {
    free(l2a(address));
}
