package com.hb13tekrar.get_load;

public class Get_Load_Ozet {
    /*

        iki methodta aynidir ayni islevi yapar  veritabanindan data getirir.
        Arka planda calisma mekanizmalari farkililik gosteriyor.

   get(): Belirli bir nesneyi veri tabanından getirir.

        1--- "get" methodu ile veritabanından bir nesne getirildiğinde, nesne hemen tamamen yüklenir ve
              tüm ilişkili verileri  de dahil olmak üzere "eager Loading"
              mekanizmasi ile tüm veriler alınır.

        2---  get ile alinan nesne kullanim icin hazirda bekletilir.
        3---  Nesne yok ise null doner --> null yapiyi optional yapilarla handle edebiliyorum!!!


   load(): Belirli bir nesneyi tembel yükleme (lazy loading) ile getirir.

        1--- "load" methodu ile veritabanından bir nesne getirildiğinde, nesne sadece  hayali/proxy bir sekilde
              yüklenir ve ilişkili veriler tembel yükleme (lazy loading)
              mekanizması kullanılarak istenildiği zaman yüklenir.

        2--- Load ile gercek bir nesne degil Proxy/hayali bir nesne alinir. nesne kullanilacagi zaman DB'ye gidilir.
             load ile bir nesne cagrildiginda kod blogu gelmis gibi davranir ama objenin kendisi gelmiyor.

        3---  nesne yok ise load methoduyla gelen golge nesneyi kullnamaya calistigimiz anda exception fırlatır
              ObjectNotFoundException" veya "EntityNotFoundException" --> Handle edemiyorum.
              (nesnenin olduğundan emin değilseniz get() kullanın demenin sebebi bu)

            --> performans acisindan getten cok daha verimli/hizli


    --> "get" ve "load" yöntemlerinin hangi durumlarda kullanılması gerektiği,
    uygulamanın gereksinimlerine ve performans hedeflerine bağlıdır.

    Hangi durumlarda get() methodu kullanilmali;

      1-   nesnenin olduğundan emin değilsek (load'ta exception firlatiyor)
      2-   dönen nesneyi hemen kullanacaksam

    Hangi durumlarda load() methodu kullanilmali;

      1-  nesnenin oldugundan eminsem
      3-  nesne'yi hemen kullanmayacaksam
      2-  dönen nesne üzerinde "DELETE" yapılacaksa !!!


 */


}
