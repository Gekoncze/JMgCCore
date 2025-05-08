#include "CConvert.h"

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

size_t l2s(jlong l, JNIEnv* env) {
    if (l < 0) {
        (*env)->ThrowNew(
            env,
            (*env)->FindClass(env, "java/lang/UnsupportedOperationException"),
            "Unsupported size."
        );
        return (size_t) 0;
    }

    return (size_t) l;
}

jlong s2l(size_t s, JNIEnv* env) {
    if (s > INT64_MAX) {
        (*env)->ThrowNew(
            env,
            (*env)->FindClass(env, "java/lang/UnsupportedOperationException"),
            "Unsupported size."
        );
        return (jlong) 0;
    }

    return (jlong) s;
}
