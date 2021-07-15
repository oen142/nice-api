package com.example.niceapi.solapi.request

data class SendMessageRequest(
    val to: String,
    val from: String,
    val text: String?,
    val type: String?,
    val country: String?,
    val subject: String?,
    val imageId: String?,
    val kakaoOptions: KakaoOption?
)

data class KakaoOption(
    val pfId: String,
    val pfGroupId: String,
    val title: String,
    val adFlag: String,
    val templateId: String,
    val disableSms: Boolean,
    val imageId: String,
    val buttons: List<KakaoButton>
)

data class KakaoButton(
    val buttonName: String,
    val buttonType: String,
    val linkMo: String?,
    val linkPc: String?,
    val linkAnd: String?,
    val lonkIos: String?
)