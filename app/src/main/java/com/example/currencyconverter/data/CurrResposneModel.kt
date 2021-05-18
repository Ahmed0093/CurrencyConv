package com.example.currencyconverter.data

import com.squareup.moshi.Json


data class CurrResposneModel(

        @Json(name = "success") val success: Boolean,
        @Json(name = "terms") val terms: String,
        @Json(name = "privacy") val privacy: String,
        @Json(name = "timestamp") val timestamp: Int,
        @Json(name = "source") val source: String,
        @Json(name = "quotes") val quotes: Quotes
)


data class Quotes(

        @Json(name = "USDAED") val USDAED: Double,
        @Json(name = "USDAFN") val USDAFN: Double,
        @Json(name = "USDALL") val USDALL: Double,
        @Json(name = "USDAMD") val USDAMD: Double,
        @Json(name = "USDANG") val USDANG: Double,
        @Json(name = "USDAOA") val USDAOA: Double,
        @Json(name = "USDARS") val USDARS: Double,
        @Json(name = "USDAUD") val USDAUD: Double,
        @Json(name = "USDAWG") val USDAWG: Double,
        @Json(name = "USDAZN") val USDAZN: Double,
        @Json(name = "USDBAM") val USDBAM: Double,
        @Json(name = "USDBBD") val USDBBD: Double,
        @Json(name = "USDBDT") val USDBDT: Double,
        @Json(name = "USDBGN") val USDBGN: Double,
        @Json(name = "USDBHD") val USDBHD: Double,
        @Json(name = "USDBIF") val USDBIF: Double,
        @Json(name = "USDBMD") val USDBMD: Double,
        @Json(name = "USDBND") val USDBND: Double,
        @Json(name = "USDBOB") val USDBOB: Double,
        @Json(name = "USDBRL") val USDBRL: Double,
        @Json(name = "USDBSD") val USDBSD: Double,
        @Json(name = "USDBTC") val USDBTC: Double,
        @Json(name = "USDBTN") val USDBTN: Double,
        @Json(name = "USDBWP") val USDBWP: Double,
        @Json(name = "USDBYN") val USDBYN: Double,
        @Json(name = "USDBYR") val USDBYR: Double,
        @Json(name = "USDBZD") val USDBZD: Double,
        @Json(name = "USDCAD") val USDCAD: Double,
        @Json(name = "USDCDF") val USDCDF: Double,
        @Json(name = "USDCHF") val USDCHF: Double,
        @Json(name = "USDCLF") val USDCLF: Double,
        @Json(name = "USDCLP") val USDCLP: Double,
        @Json(name = "USDCNY") val USDCNY: Double,
        @Json(name = "USDCOP") val USDCOP: Double,
        @Json(name = "USDCRC") val USDCRC: Double,
        @Json(name = "USDCUC") val USDCUC: Double,
        @Json(name = "USDCUP") val USDCUP: Double,
        @Json(name = "USDCVE") val USDCVE: Double,
        @Json(name = "USDCZK") val USDCZK: Double,
        @Json(name = "USDDJF") val USDDJF: Double,
        @Json(name = "USDDKK") val USDDKK: Double,
        @Json(name = "USDDOP") val USDDOP: Double,
        @Json(name = "USDDZD") val USDDZD: Double,
        @Json(name = "USDEGP") val USDEGP: Double,
        @Json(name = "USDERN") val USDERN: Double,
        @Json(name = "USDETB") val USDETB: Double,
        @Json(name = "USDEUR") val USDEUR: Double,
        @Json(name = "USDFJD") val USDFJD: Double,//
        @Json(name = "USDFKP") val USDFKP: Double,
        @Json(name = "USDGBP") val USDGBP: Double,
        @Json(name = "USDGEL") val USDGEL: Double,
        @Json(name = "USDGGP") val USDGGP: Double,//
        @Json(name = "USDGHS") val USDGHS: Double,
        @Json(name = "USDGIP") val USDGIP: Double,
        @Json(name = "USDGMD") val USDGMD: Double,
        @Json(name = "USDGNF") val USDGNF: Double,
        @Json(name = "USDGTQ") val USDGTQ: Double,
        @Json(name = "USDGYD") val USDGYD: Double,
        @Json(name = "USDHKD") val USDHKD: Double,
        @Json(name = "USDHNL") val USDHNL: Double,
        @Json(name = "USDHRK") val USDHRK: Double,
        @Json(name = "USDHTG") val USDHTG: Double,
        @Json(name = "USDHUF") val USDHUF: Double,
        @Json(name = "USDIDR") val USDIDR: Double,
        @Json(name = "USDILS") val USDILS: Double,
        @Json(name = "USDIMP") val USDIMP: Double,
        @Json(name = "USDINR") val USDINR: Double,
        @Json(name = "USDJPY") val USDJPY: Double
//    @Json(name = "USDIQD") val USDIQD: Double,
//    @Json(name = "USDIRR") val USDIRR: Double,
//    @Json(name = "USDISK") val USDISK: Double,
//    @Json(name = "USDJEP") val USDJEP: Double,
//    @Json(name = "USDJMD") val USDJMD: Double,
//    @Json(name = "USDJOD") val USDJOD: Double,
//    @Json(name = "USDKES") val USDKES: Double,
//    @Json(name = "USDKGS") val USDKGS: Double,
//    @Json(name = "USDKHR") val USDKHR: Double,
//    @Json(name = "USDKMF") val USDKMF: Double,
//    @Json(name = "USDKPW") val USDKPW: Double,
//    @Json(name = "USDKRW") val USDKRW: Double,
//    @Json(name = "USDKWD") val USDKWD: Double,
//    @Json(name = "USDKYD") val USDKYD: Double,
//    @Json(name = "USDKZT") val USDKZT: Double,
//    @Json(name = "USDLAK") val USDLAK: Double,
//    @Json(name = "USDLBP") val USDLBP: Double,
//    @Json(name = "USDLKR") val USDLKR: Double,
//    @Json(name = "USDLRD") val USDLRD: Double,
//    @Json(name = "USDLSL") val USDLSL: Double,
//    @Json(name = "USDLTL") val USDLTL: Double,
//    @Json(name = "USDLVL") val USDLVL: Double,
//    @Json(name = "USDLYD") val USDLYD: Double,
//    @Json(name = "USDMAD") val USDMAD: Double,
//    @Json(name = "USDMDL") val USDMDL: Double,
//    @Json(name = "USDMGA") val USDMGA: Double,
//    @Json(name = "USDMKD") val USDMKD: Double,
//    @Json(name = "USDMMK") val USDMMK: Double,
//    @Json(name = "USDMNT") val USDMNT: Double,
//    @Json(name = "USDMOP") val USDMOP: Double,
//    @Json(name = "USDMRO") val USDMRO: Double,
//    @Json(name = "USDMUR") val USDMUR: Double,
//    @Json(name = "USDMVR") val USDMVR: Double,
//    @Json(name = "USDMWK") val USDMWK: Double,
//    @Json(name = "USDMXN") val USDMXN: Double,
//    @Json(name = "USDMYR") val USDMYR: Double,
//    @Json(name = "USDMZN") val USDMZN: Double,
//    @Json(name = "USDNAD") val USDNAD: Double,
//    @Json(name = "USDNGN") val USDNGN: Double,
//    @Json(name = "USDNIO") val USDNIO: Double,
//    @Json(name = "USDNOK") val USDNOK: Double,
//    @Json(name = "USDNPR") val USDNPR: Double,
//    @Json(name = "USDNZD") val USDNZD: Double,
//    @Json(name = "USDOMR") val USDOMR: Double,
//    @Json(name = "USDPAB") val USDPAB: Double,
//    @Json(name = "USDPEN") val USDPEN: Double,
//    @Json(name = "USDPGK") val USDPGK: Double,
//    @Json(name = "USDPHP") val USDPHP: Double,
//    @Json(name = "USDPKR") val USDPKR: Double,
//    @Json(name = "USDPLN") val USDPLN: Double,
//    @Json(name = "USDPYG") val USDPYG: Double,
//    @Json(name = "USDQAR") val USDQAR: Double,
//    @Json(name = "USDRON") val USDRON: Double,
//    @Json(name = "USDRSD") val USDRSD: Double,
//    @Json(name = "USDRUB") val USDRUB: Double,
//    @Json(name = "USDRWF") val USDRWF: Double,
//    @Json(name = "USDSAR") val USDSAR: Double,
//    @Json(name = "USDSBD") val USDSBD: Double,
//    @Json(name = "USDSCR") val USDSCR: Double,
//    @Json(name = "USDSDG") val USDSDG: Double,
//    @Json(name = "USDSEK") val USDSEK: Double,
//    @Json(name = "USDSGD") val USDSGD: Double,
//    @Json(name = "USDSHP") val USDSHP: Double,
//    @Json(name = "USDSLL") val USDSLL: Double,
//    @Json(name = "USDSOS") val USDSOS: Double,
//    @Json(name = "USDSRD") val USDSRD: Double,
//    @Json(name = "USDSTD") val USDSTD: Double,
//    @Json(name = "USDSVC") val USDSVC: Double,
//    @Json(name = "USDSYP") val USDSYP: Double,
//    @Json(name = "USDSZL") val USDSZL: Double,
//    @Json(name = "USDTHB") val USDTHB: Double,
//    @Json(name = "USDTJS") val USDTJS: Double,
//    @Json(name = "USDTMT") val USDTMT: Double,
//    @Json(name = "USDTND") val USDTND: Double,
//    @Json(name = "USDTOP") val USDTOP: Double,
//    @Json(name = "USDTRY") val USDTRY: Double,
//    @Json(name = "USDTTD") val USDTTD: Double,
//    @Json(name = "USDTWD") val USDTWD: Double,
//    @Json(name = "USDTZS") val USDTZS: Double,
//    @Json(name = "USDUAH") val USDUAH: Double,
//    @Json(name = "USDUGX") val USDUGX: Double,
//    @Json(name = "USDUSD") val USDUSD: Double,
//    @Json(name = "USDUYU") val USDUYU: Double,
//    @Json(name = "USDUZS") val USDUZS: Double,
//    @Json(name = "USDVEF") val USDVEF: Double,
//    @Json(name = "USDVND") val USDVND: Double,
//    @Json(name = "USDVUV") val USDVUV: Double,
//    @Json(name = "USDWST") val USDWST: Double,
//    @Json(name = "USDXAF") val USDXAF: Double,
//    @Json(name = "USDXAG") val USDXAG: Double,
//    @Json(name = "USDXAU") val USDXAU: Double,
//    @Json(name = "USDXCD") val USDXCD: Double,
//    @Json(name = "USDXDR") val USDXDR: Double,
//    @Json(name = "USDXOF") val USDXOF: Double,
//    @Json(name = "USDXPF") val USDXPF: Double,
//    @Json(name = "USDYER") val USDYER: Double,
//    @Json(name = "USDZAR") val USDZAR: Double,
//    @Json(name = "USDZMK") val USDZMK: Double,
//    @Json(name = "USDZMW") val USDZMW: Double,
//    @Json(name = "USDZWL") val USDZWL: Double
) {
    fun getCurrListAsMap(): LinkedHashMap<String, Double> {
        val currListMap = LinkedHashMap<String, Double>()

        //
        currListMap.put("AED", USDAED)
        currListMap.put("AFN", USDAFN)
        currListMap.put("ALL", USDALL)
        currListMap.put("AMD", USDAMD)
        currListMap.put("ANG", USDANG)
        currListMap.put("AOA", USDAOA)
        currListMap.put("ARS", USDARS)
        currListMap.put("AUD", USDAUD)
        currListMap.put("AWG", USDAWG)
        currListMap.put("AZN", USDAZN)
        currListMap.put("BAM", USDBAM)
        currListMap.put("BBD", USDBBD)
        currListMap.put("BDT", USDBDT)
        currListMap.put("BGN", USDBGN)
        currListMap.put("BHD", USDBHD)
        currListMap.put("BIF", USDBIF)
        currListMap.put("BMD", USDBMD)
        currListMap.put("BND", USDBND)
        currListMap.put("BOB", USDBOB)
        currListMap.put("BRL", USDBRL)
        currListMap.put("EGP", USDEGP)
        currListMap.put("EUR", USDEUR)
        currListMap.put("BYN", USDBYN)
        currListMap.put("JPY", USDJPY)
        currListMap.put("CNY", USDCNY)
        currListMap.put("USD", 1.0)

//......

//        @Json(name = "USDBSD") val USDBSD: Double,
//        @Json(name = "USDBTC") val USDBTC: Double,
//        @Json(name = "USDBTN") val USDBTN: Double,
//        @Json(name = "USDBWP") val USDBWP: Double,
//        @Json(name = "USDBYN") val USDBYN: Double,
//        @Json(name = "USDBYR") val USDBYR: Double,
//        @Json(name = "USDBZD") val USDBZD: Double,
//        @Json(name = "USDCAD") val USDCAD: Double,
//        @Json(name = "USDCDF") val USDCDF: Double,
//        @Json(name = "USDCHF") val USDCHF: Double,
//        @Json(name = "USDCLF") val USDCLF: Double,
//        @Json(name = "USDCLP") val USDCLP: Double,
//        @Json(name = "USDCOP") val USDCOP: Double,
//        @Json(name = "USDCRC") val USDCRC: Double,
//        @Json(name = "USDCUC") val USDCUC: Double,
//        @Json(name = "USDCUP") val USDCUP: Double,
//        @Json(name = "USDCVE") val USDCVE: Double,
//        @Json(name = "USDCZK") val USDCZK: Double,
//        @Json(name = "USDDJF") val USDDJF: Double,
//        @Json(name = "USDDKK") val USDDKK: Double,
//        @Json(name = "USDDOP") val USDDOP: Double,
//        @Json(name = "USDDZD") val USDDZD: Double,
//        @Json(name = "USDERN") val USDERN: Double,
//        @Json(name = "USDETB") val USDETB: Double,
//        @Json(name = "USDEUR") val USDEUR: Double,
//        @Json(name = "USDFJD") val USDFJD: Double,//


        return currListMap
    }
}