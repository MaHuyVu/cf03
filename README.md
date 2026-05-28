# CF03 - Rò Rỉ Secret GitHub / Lộ API Key

## Mô tả

Dự án này mô phỏng một vấn đề an ninh mạng phổ biến:
hardcode API key và làm lộ secret trong source code.

Dự án bao gồm:
- Ví dụ hardcode secret key
- Sử dụng biến môi trường an toàn
- Scanner phát hiện secret key
- Phòng tránh lộ secret trên GitHub

## Công nghệ sử dụng
- Java
- Environment Variables
- Regex Scanner

## Cách chạy

Compile:
cd cf03-secret-leak
javac src/*.java

cp src SecretScannerGUI
Run:

java -cp src Main