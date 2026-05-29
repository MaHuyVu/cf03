# CF03 - Rò Rỉ Secret GitHub / Lộ API Key

## Mô tả

Dự án này mô phỏng một vấn đề an ninh mạng phổ biến:
hardcode API key và làm lộ secret trong source code.

Dự án bao gồm:

* Ví dụ hardcode secret key
* Sử dụng biến môi trường an toàn (.env)
* Scanner phát hiện secret key bằng Regex
* Phòng tránh lộ secret trên GitHub bằng .gitignore

## Công nghệ sử dụng

* Java
* Swing GUI
* Environment Variables (.env)
* Regex Scanner
* Git / GitHub

## Cách chạy

### 1. đúng file

```bash
cd cf03-secret-leak
```

### 2. Biên dịch chương trình

```bash
javac src/Main.java src/SecretScanner.java src/SecretScannerGUI.java
```

### 3. Chạy bản Console

```bash
java -cp src Main
```

### 4. Chạy bản Giao diện (GUI)

```bash
java -cp src SecretScannerGUI
```

## Demo

### API Key bị hardcode (không an toàn)

```java
String api = "sk_live_SECRET_123456";
```

### API Key lưu trong file .env (an toàn hơn)

```env
API_KEY=sk_secure_987654321
```

### Kết quả

* Scanner phát hiện API Key bị hardcode trong source code.
* API Key trong file .env không bị đưa trực tiếp vào mã nguồn.
* File .env được loại khỏi GitHub bằng .gitignore.

## Biện pháp khắc phục

* Không hardcode(mã cứng) API Key trong source code.
* Sử dụng biến môi trường hoặc file .env.
* Thêm .env vào .gitignore.
* Sử dụng công cụ quét secret trước khi push code lên GitHub.
