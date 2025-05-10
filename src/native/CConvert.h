#ifndef CCADDRESS_H
#define CCADDRESS_H

#include <jni.h>
#include <stddef.h>
#include <stdint.h>

void* l2p(jlong l);
jlong p2l(void* a);
size_t l2s(jlong l, JNIEnv* env);
jlong s2l(size_t s, JNIEnv* env);

#endif
