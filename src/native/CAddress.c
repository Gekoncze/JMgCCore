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
