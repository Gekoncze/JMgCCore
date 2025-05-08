#include "CAddress.h"

void* l2a(jlong l) {
    union {
        jlong l;
        void* a;
    } c;
    c.l = l;
    return c.a;
}

jlong a2l(void* a) {
    union {
        jlong l;
        void* a;
    } c;
    c.a = a;
    return c.l;
}

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_common_CAddress_plus(JNIEnv* env, jclass clazz, jlong address, jlong delta) {
    return a2l(l2a(address) + delta);
}
