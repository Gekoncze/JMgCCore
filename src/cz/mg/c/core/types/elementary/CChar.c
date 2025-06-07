#include "../../CConvert.h"

JNIEXPORT jlong JNICALL Java_cz_mg_c_core_entities_types_elementary_CChar_nativeSize(JNIEnv* env, jclass clazz) {
    return sizeof(char);
}
