FROM openjdk:11-slim

# 作業ディレクトリを設定
WORKDIR /app

# Javaファイルをコピー
COPY ComputerHand.java /app/ComputerHand.java
COPY Judge.java /app/Judge.java
COPY Main.java /app/Main.java
COPY PanelMaker.java /app/PanelMaker.java
COPY TextMaker.java /app/TextMaker.java

# Javaファイルをコンパイル
RUN javac Main.java

# ポート8080を公開
EXPOSE 8080

# アプリケーションを実行
CMD ["java", "Main"]
