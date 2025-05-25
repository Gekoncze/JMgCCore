#include "CConvert.h"

void* l2p(jlong l) {
    union {
        jlong l;
        void* a;
    } c;
    c.l = l;
    return c.a;
}

jlong p2l(void* a) {
    union {
        jlong l;
        void* a;
    } c;
    c.a = a;
    return c.l;
}
