# InternUp - Staj Takip Sistemi

Spring Boot kullanılarak geliştirilmiş tam kapsamlı bir Staj Takip Sistemidir. Sistem, öğrencilerin staj ilanlarını görüntülemesine ve başvuru yapmasına olanak sağlarken; yöneticilerin staj ilanlarını ve başvuru süreçlerini yönetebilmesini sağlar.

---

## Özellikler

### Kullanıcı Özellikleri

* Kullanıcı Girişi ve Kayıt Olma
* Profil Yönetimi
* CV Yükleme
* Şirket veya Pozisyona Göre Staj İlanı Arama
* Staj İlanlarına Başvuru Yapma
* Yapılan Başvuruları Görüntüleme

### Yönetici Özellikleri

* Yönetici Girişi
* Staj İlanı Oluşturma
* Staj İlanı Güncelleme
* Staj İlanı Silme
* Başvuruları Görüntüleme
* Başvuru Durumlarını Güncelleme

### Başvuru Durumu Takibi

* APPLIED (Başvuru Yapıldı)
* INTERVIEW (Mülakat)
* OFFER (Teklif)
* REJECTED (Reddedildi)

---

## Kullanılan Teknolojiler

### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* Maven

### Frontend

* HTML
* CSS
* JavaScript

### Veritabanı

* H2 Database

### Araçlar

* IntelliJ IDEA
* Postman
* Git
* GitHub

---

## Proje Mimarisi

Projede katmanlı mimari yaklaşımı kullanılmıştır.

* Controller Katmanı
* Service Katmanı
* Repository Katmanı
* Entity Katmanı
* DTO Katmanı
* Validation Katmanı
* Global Exception Handling

---

## Güvenlik

Projede Spring Security kullanılarak Rol Tabanlı Yetkilendirme (RBAC) uygulanmıştır.

### Roller

* ADMIN
* USER

Kimlik doğrulama ve yetkilendirme işlemleri Spring Security ile gerçekleştirilmiştir.

---

## API Uç Noktaları (Endpoints)

### Staj İlanı İşlemleri

* GET /api/internships
* POST /api/internships
* PUT /api/internships/{id}
* DELETE /api/internships/{id}

### Başvuru İşlemleri

* GET /api/applications
* POST /api/applications
* PUT /api/applications/{id}/status

---

## Ekran Görüntüleri

<img width="1900" alt="Giriş Ekranı" src="https://github.com/user-attachments/assets/1170f51d-3fe2-4233-b418-09dcef717a85" />

<img width="1895" alt="Giriş Ekranı" src="https://github.com/user-attachments/assets/15264ef5-f450-48fe-9a08-43b216d20411" />

<img width="1885" alt="Kullanıcı Paneli" src="https://github.com/user-attachments/assets/5baffb24-c59d-4975-9562-dac74c30bfb9" />

<img width="1892" alt="Yönetici Paneli" src="https://github.com/user-attachments/assets/6886564d-a7fe-46b0-907f-7dfa8543d2c0" />

<img width="1885" alt="Yönetici Paneli" src="https://github.com/user-attachments/assets/f6710293-9853-4eab-83e4-763f5d2f0218" />

<img width="1917" alt="H2 Database" src="https://github.com/user-attachments/assets/0431e1dc-d288-48bc-baeb-203949a6b6c2" />

<img width="1916" alt="Postman Testleri" src="https://github.com/user-attachments/assets/25cea5d0-1d60-4eb4-a3f6-d39aa261db49" />

---

## Gelecek Geliştirmeler

* Şirket paneli entegrasyonu
* E-posta bildirim sistemi
* JWT tabanlı kimlik doğrulama
* PostgreSQL desteği
* Docker entegrasyonu
* Gerçek zamanlı bildirim sistemi

---

## Geliştirici

**Selin Kuru**

Yönetim Bilişim Sistemleri Öğrencisi

Spring Boot Tabanlı Staj Takip Sistemi Projesi
