#include "CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_entities_CPointer_sizeof(JNIEnv* env, jclass clazz) {
    return sizeof(void*);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_entities_CPointer_nativeGet(JNIEnv* env, jclass clazz, jlong address) {
    void** ptrptr = (void**) l2p(address);
    void* ptr = *ptrptr;
    return p2l(ptr);
}

JNIEXPORT void JNICALL Java_cz_mg_c_core_entities_CPointer_nativeSet(JNIEnv* env, jclass clazz, jlong address, jlong value) {
    void** ptrptr = (void**) l2p(address);
    *ptrptr = l2p(value);
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_entities_CPointer_nativePlus(JNIEnv* env, jclass clazz, jlong address, jlong delta) {
    return p2l(l2p(address) + delta);
}
