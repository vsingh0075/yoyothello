package kids.cute.spacethello.activities;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import kids.cute.spacethello.R;

/**
 * Created by sarthak on 19/1/16.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    public final int SUN =1;
    public final int MOON=2;
    private float gotix,gotiy;
    private boolean CPU;
    private boolean undo;
    public static final int WIDTH=800;
    public static final int HEIGHT=1000;
    private SurfaceHolder surfaceHolder;
    private int [][] presentGrid = new int[9][9];
    private int [][] previousGrid = new int[9][9];
    public GamePanel(Context context)
    {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder)
    {
        presentGrid[4][4]=MOON;
        presentGrid[5][5]=MOON;
        presentGrid[4][5]=SUN;
        presentGrid[5][4]=SUN;
        CPU=false;
        undo=true;
        handleAndDraw();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder)
    {

    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height)
    {

    }

    public void updateGrid(float touchX, float touchY)
    {
        int i,j;
        i= (int)( Math.ceil((touchX -25)/93.75) );
        j= (int)( Math.ceil((touchY -45)/93.75) );
        if(CPU == false)
        {
            presentGrid[i][j]=SUN;
            CPU=true;
        }
        else
        {
            presentGrid[i][j]=MOON;
            CPU=false;
        }
        undo=true;
        handleAndDraw();
    }

    public void undoAction()
    {
        if(undo)
        {
            undo=false;
        }
        handleAndDraw();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            final float scaleFactorX= getWidth()/(WIDTH*1.0f);
            final float scaleFactorY= getHeight()/(HEIGHT*1.0f);
            final float scaleFactor = minimum(scaleFactorX, scaleFactorY);
            System.out.println(scaleFactorX + " " + scaleFactorY);
            float touchX= event.getX()/scaleFactor;
            float touchY= event.getY()/scaleFactor;
            if(touchY>45 &&  touchY < 805 && touchX >25 && touchX < 775)
            {
                updateGrid(touchX,touchY);
            }
            else
            {
                touchX=event.getX()/scaleFactorX;
                touchY=event.getY()/scaleFactorY;
                if(touchX > 325 && touchX < 475 && touchY > 840 && touchY < 890)
                undoAction();
            }
            System.out.println("clicked at "+ touchX + " " + touchY);
        }
        return super.onTouchEvent(event);
    }

    public float minimum(float a, float b)
    {
        return (a < b)?a:b;
    }

    public void setPosition(float i,float j)
    {
        gotix = 25.0f + (i-1)*93.75f;
        gotiy = 55.0f + (j-1)*93.75f;
    }

    public void drawGrid(Canvas canvas)
    {
        int i,j;
        for(i=1;i<=8;i++)
        {
            for(j=1;j<=8;j++)
            {
                System.out.print(presentGrid[i][j] + " " );
                setPosition(i,j);
                if(presentGrid[i][j] == SUN)
                {
                    canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sungoti), gotix, gotiy, null );
                }
                else if(presentGrid[i][j] == MOON)
                {
                    canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.moongoti), gotix, gotiy, null );
                }
            }
            System.out.println();
        }
    }
    public void drawButtons(Canvas canvas)
    {
        if(CPU)
        {
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.cpuscore), 20, 840, null);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.youscore2), 480, 840, null);
        }
        else
        {
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.cpuscore2), 20, 840, null);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.youscore), 480, 840, null);
        }

        if(undo)
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.undo), 325, 840, null);
        else
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.undo2), 325, 840, null);
    }

    public void draw(Canvas canvas)
    {
        final float scaleFactorX=getWidth()/(WIDTH*1.0f);
        final float scaleFactorY=getHeight()/(HEIGHT*1.0f);
        final float scaleFactor=minimum(scaleFactorX , scaleFactorY);

        if(canvas!=null)
        {
            final int savedState=canvas.save();

            canvas.scale(scaleFactorX, scaleFactorY);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.spacethellobg), 0, 0, null);
            drawButtons(canvas);
            canvas.restoreToCount(savedState);

            canvas.scale(scaleFactor, scaleFactor);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.final_gameboard), 0, 30, null);
            drawGrid(canvas);
            canvas.restoreToCount(savedState);
        }
    }

    public void handleAndDraw()
    {
        Canvas canvas=null;

        try{
            canvas=getHolder().lockCanvas();
            draw(canvas);
        }
        catch (Exception e){}
        finally{
            try{
                getHolder().unlockCanvasAndPost(canvas);
            }
            catch (Exception e){e.printStackTrace();}
        }
    }
}
