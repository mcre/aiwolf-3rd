チームm_cre (プロトコル部門)
====

[第3回人狼知能大会](http://aiwolf.org/3rd-aiwolf-contest) プロトコル部門の出場エージェントです。

## プレイヤーjarファイル

* [McrePlayer.jar](/McrePlayer.jar)
  + クラスは `net.mchs_u.mc.aiwolf.dokin.McrePlayer` を指定してください。

## クラス説明

* net.mchs_u.mc.aiwolf.dokin.McrePlayer
  + 今回の出場エージェント
  
* net.mchs_u.mc.aiwolf.eclair.McrePlayer
  + 作りかけで諦めたエージェント


Mainクラスから参照している`bakin04`(第2回出場エージェント), `curry`(GAT2017出場エージェント)は[こちら](https://github.com/mcre/aiwolf-gat2017/blob/master/McrePlayer.jar)の中にあります。

## プログラム解説

人狼知能プレ大会@GAT2017の提出エージェントをベースにしています。
人狼知能プレ大会@GAT2017の提出エージェントについては[こちら](https://github.com/mcre/aiwolf-gat2017)をご覧ください。
変更点は以下のとおりです。

* バグ修正
  + 予備予選でぬるぽ発生していた箇所を回避
  + 「狂人が人狼に黒出し・人狼が狂人に黒出し・人狼が人狼に黒出し」での確率調整について、白出しでも同様な調整をするようになっていたバクを修正
* 新規エージェントの作成
  + ログからCO状態での確率調整を行おうとしたeclairは完成せず今回は諦めた

## 連絡先

* [twitter: @m_cre](https://twitter.com/m_cre)
* [blog](http://www.mchs-u.net/mc/)

## License

* MIT
  + see LICENSE