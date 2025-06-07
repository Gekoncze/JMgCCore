#ifndef CCADDRESS_H
#define CCADDRESS_H

#include <jni.h>
#include <stddef.h>
#include <stdint.h>
#include <limits.h>

void* l2p(jlong l);
jlong p2l(void* a);

#endif
