module UniversityManagementSystem {
}
/*
Üniversite Ders ve Öğrenci Yönetimi

Amaç: Ders açma, kayıt (enrollment), notlandırma.
Minimum Kapsam: Ders oluştur, öğrenci kaydı, derse kayıt, not girme/ortalama hesaplama.

Varlıklar & İlişkiler: Student N—N Course (Enrollment), Instructor 1—N Course

İş Kuralları: Kota dolu derse kayıt olmaz; (opsiyonel) önkoşul sağlanmalı.

Örnek Senaryo: Öğrenci CS101’e kayıt olur; final sonrası not girilir; GPA güncellenir.

Teslimatlar: Dönem bazlı listeleme, not dağılım raporu, test (kota, not aralığı).

Genişletme: Çakışan ders saatlerini engelleme, danışman onayı.


*/