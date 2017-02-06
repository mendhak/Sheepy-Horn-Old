package com.mendhak.sheepyhorn;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class PlaySoundActivity extends Activity {
    boolean alreadyPlaying;
    MediaPlayer mp;

    /* renamed from: com.mendhak.sheepyhorn.PlaySoundActivity.1 */
    class C00011 implements OnClickListener {

        /* renamed from: com.mendhak.sheepyhorn.PlaySoundActivity.1.1 */
        class C00001 implements OnCompletionListener {
            C00001() {
            }

            public void onCompletion(MediaPlayer mp) {
                PlaySoundActivity.this.alreadyPlaying = false;
            }
        }

        C00011() {
        }

        public void onClick(View v) {
            if (!PlaySoundActivity.this.alreadyPlaying) {
                try {
                    PlaySoundActivity.this.alreadyPlaying = true;
                    PlaySoundActivity.this.mp.start();
                    PlaySoundActivity.this.mp.setOnCompletionListener(new C00001());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0002R.layout.main);
        setTheme(C0002R.style.Dark);
        this.mp = MediaPlayer.create(getBaseContext(), C0002R.raw.sheepyhorn);
        findViewById(C0002R.id.sound_button).setOnClickListener(new C00011());
    }
}
