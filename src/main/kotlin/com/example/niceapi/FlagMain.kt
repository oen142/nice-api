package com.example.niceapi

import NiceID.Check.CPClient

object FlagMain {
    fun niceCheck(): String {
        val niceCheck = CPClient();

        val sSiteCode = "";
        val sSitePassword = "";

        val sRequestNumber = niceCheck.getRequestNO(sSiteCode)


        //session.setAttribute("REQ_SEQ", sRequestNumber);    // 해킹등의 방지를 위하여 세션을 쓴다면, 세션에 요청번호를 넣는다.

        val sAuthType = "";

        ;        // 없으면 기본 선택화면, M: 핸드폰, C: 신용카드, X: 공인인증서

        val popgubun = "Y"
        val customize = "Mobile"

        //Y : 취소버튼 있음 / N : 취소버튼 없음
        //없으면 기본 웹페이지 / Mobile : 모바일페이지

        val sGender = "1";
        //없으면 기본 선택 값, 0 : 여자, 1 : 남자

        // CheckPlus(본인인증) 처리 후, 결과 데이타를 리턴 받기위해 다음예제와 같이 http부터 입력합니다.
        //리턴url은 인증 전 인증페이지를 호출하기 전 url과 동일해야 합니다. ex) 인증 전 url : http://www.~ 리턴 url : http://www.~

        val sReturnUrl = "http://localhost:8080/success"      // 성공시 이동될 URL
        val sErrorUrl = "http://localhost:8080/fail"          // 실패시 이동될 URL


        val sPlainData = "7:REQ_SEQ${sRequestNumber.length}:$sRequestNumber" +
                "8:SITECODE${sSiteCode.length}:$sSiteCode"
        "9:AUTH_TYPE${sAuthType.length}:$sAuthType"
        "7:RTN_UR${sReturnUrl.length}:$sReturnUrl"
        "7:ERR_URL${sErrorUrl.length}:$sErrorUrl"
        "11:POPUP_GUBUN${popgubun.length}:$popgubun"
        "9:CUSTOMIZE${customize.length}:$customize"
        "6:GENDER${sGender.length}:$sGender"


        val iReturn = niceCheck.fnEncode(sSiteCode, sSitePassword, sPlainData)
        println("iReturn = ${iReturn}")
        val sMessage = when (iReturn) {
            0 -> {
                niceCheck.cipherData
            }
            -1 -> {
                "암호화 시스템 에러입니다."
            }
            -2 -> {
                "암호화 처리오류입니다."
            }
            -3 -> {
                "암호화 데이터 오류입니다."
            }
            -9 -> {
                "입력 데이터 오류입니다."
            }
            else -> {
                "알수 없는 에러 입니다. iReturn : " + iReturn
            }
        }
        return niceCheck.cipherData
    }

    fun requestReplace(param: String, gubun: String): String {
        var result = "";

        var paramValue = ""
        if (param != null) {

            paramValue = paramValue.replace("<", "&lt;").replace(">", "&gt;");

            paramValue = paramValue.replace("\\*", "");
            paramValue = paramValue.replace("\\?", "");
            paramValue = paramValue.replace("\\[", "");
            paramValue = paramValue.replace("\\{", "");
            paramValue = paramValue.replace("\\(", "");
            paramValue = paramValue.replace("\\)", "");
            paramValue = paramValue.replace("\\^", "");
            paramValue = paramValue.replace("\\$", "");
            paramValue = paramValue.replace("'", "");
            paramValue = paramValue.replace("@", "");
            paramValue = paramValue.replace("%", "");
            paramValue = paramValue.replace(";", "");
            paramValue = paramValue.replace(":", "");
            paramValue = paramValue.replace("-", "");
            paramValue = paramValue.replace("#", "");
            paramValue = paramValue.replace("--", "");
            paramValue = paramValue.replace("-", "");
            paramValue = paramValue.replace(",", "");

            if (gubun != "encodeData") {
                paramValue = paramValue.replace("\\+", "");
                paramValue = paramValue.replace("/", "");
                paramValue = paramValue.replace("=", "");
            }

            result = paramValue;

        }
        return result;
    }
}