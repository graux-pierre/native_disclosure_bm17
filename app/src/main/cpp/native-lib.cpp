#include <jni.h>
#include <string>

extern "C" JNIEXPORT void JNICALL
Java_lu_uni_graux_bm17_MainActivity_fieldCopyUsingJNI(
        JNIEnv* env,
        jobject thisObj) {
    jclass cid = env->GetObjectClass(thisObj);
    jclass cid2 = env->FindClass("lu/uni/graux/bm17/MainActivity");

    jfieldID fidImei = env->GetFieldID(cid, "imei", "Ljava/lang/String;");
    jfieldID fidStaticImei = env->GetStaticFieldID(cid2, "staticImei", "Ljava/lang/String;");

    jfieldID fidNotImei = env->GetFieldID(cid2, "notImei", "Ljava/lang/String;");
    jfieldID fidStaticNotImei = env->GetStaticFieldID(cid, "staticNotImei", "Ljava/lang/String;");

    env->SetObjectField(thisObj, fidNotImei, env->GetObjectField(thisObj, fidImei));
    env->SetStaticObjectField(cid2, fidStaticNotImei, env->GetStaticObjectField(cid, fidStaticImei));
}