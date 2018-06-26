package jonathanalvarez.navegador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView browser;
    Button back,refresh,go,buscar;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser=(WebView)findViewById(R.id.vistaweb);
        back=(Button)findViewById(R.id.btnback);
        refresh=(Button)findViewById(R.id.btnrefresh);
        go=(Button)findViewById(R.id.btngo);
        buscar=(Button)findViewById(R.id.buscar);
        url=(EditText)findViewById(R.id.url);

        //browser.loadData("<HTML>Hola Mundo</HTML>","text/html","UTF-8");

        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("http://google.com");

        browser.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browser.goBack();
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browser.reload();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browser.goForward();
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browser.loadUrl(url.getText().toString());
            }
        });

        }
    }