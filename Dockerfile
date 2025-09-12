FROM openjdk:11-slim

# 作業ディレクトリを設定
WORKDIR /app

# Javaファイルをコピー
COPY ComputerHand.java /app/ComputerHand.java
COPY Judge.java /app/Judge.java
COPY Main.java /app/Main.java
COPY PanelMaker.java /app/PanelMaker.java
COPY TextMaker.java /app/TextMaker.java

# ビルドと実行の手順﻿
# Dockerfileがあるディレクトリで、コマンドを実行してDockerイメージをビルドします。
docker build -t my-janken-game . 

# コマンドでコンテナを起動します。
docker run -p 8080:8080 my-janken-game 

# Javaファイルをコンパイル
# RUN javac Main.java

# ポート8080を公開
# EXPOSE 8080

# アプリケーションを実行
# CMD ["java", "Main"]
