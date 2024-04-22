package study.oopstudy.racinggame.broadcast;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.oopstudy.racinggame.model.Players;

class BroadCasterTest {

  @Test
  @DisplayName("브로드케스트_동작_확인")
  void 브로드케스트_동작_확인() {
    //    given
    String PlayerNames = "test1,test2,test3";
    Players players = new Players(PlayerNames);
    BroadCaster broadCaster = new BroadCaster(players);

    //    when
    //    then
    broadCaster.start(3);
  }
}
