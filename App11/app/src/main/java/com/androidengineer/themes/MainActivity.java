package com.androidengineer.themes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

    private View middle;
    private View leftTop;
    private View leftBottom;
    private View rightBottom;
    private View rightTop;
    private View middleTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        middle = findViewById(R.id.middle);
        leftTop = findViewById(R.id.leftTop);
        leftBottom = findViewById(R.id.leftBottom);
        rightBottom = findViewById(R.id.rightBottom);
        rightTop = findViewById(R.id.rightTop);
        middleTop= findViewById(R.id.middleTop);

        leftTop.setOnClickListener(this);
        leftBottom.setOnClickListener(this);
        rightBottom.setOnClickListener(this);
        rightTop.setOnClickListener(this);
        middle.setOnClickListener(this);
        middleTop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.leftTop:
                new ErrorIconDecorator(view);
                break;

            case R.id.leftBottom:
                new WarningIconDecorator(view);
                break;

            case R.id.rightTop:
                new InfoIconDecorator(view);
                break;

            case R.id.rightBottom:
                new QuickFixIconDecorator(view);
                break;

            case R.id.middleTop:
                new IconDecorator(this,view, R.drawable.newpack_wiz);
                break;

            case R.id.middle:
                final View[] views = new View[]{leftTop,leftBottom,rightTop,rightBottom,middleTop};
                new UndoIconDecorator(views);
                break;
            default:
                break;
        }
    }

    // you may define specific decorators to your convenience...
    // ... or you may use directly the universal decorator IconDecorator(...).
    // It is up to your. Here i'm showing both examples

    public class WarningIconDecorator{
        public WarningIconDecorator(View view){
            new IconDecorator(MainActivity.this, view, R.drawable.warning_obj);
        }
    }

    public class ErrorIconDecorator {
        public ErrorIconDecorator(View view){
            new IconDecorator(MainActivity.this, view, R.drawable.error);
        }
    }

    public class InfoIconDecorator {
        public InfoIconDecorator(View view){
            new IconDecorator(MainActivity.this, view, R.drawable.information);
        }
    }

    public class PackageDecorator {
        public PackageDecorator(View view){
            new IconDecorator(MainActivity.this, view, R.drawable.package_obj);
        }
    }

    public class QuickFixIconDecorator {
        public QuickFixIconDecorator(View view){
            new IconDecorator(MainActivity.this, view, R.drawable.quickfix_error_obj);
        }
    }

    public class ErrorWarningDecorator {
        public ErrorWarningDecorator(View view){
            new IconDecorator(MainActivity.this, view, R.drawable.errorwarning_tab);
        }
    }

    public class UndoIconDecorator{
        public UndoIconDecorator(View[] views){
            new ClearIconDecorator(MainActivity.this, views);
        }
    }
}
