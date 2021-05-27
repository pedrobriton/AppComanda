package pedro.neto.com.projetocomanda

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*
import scarlet.machado.lmsapp.R


class MainActivity : DebugActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelID = "Pedro"
    private val desc = "Notificação.:"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        /*variáveis padrões*/
        val nome_padrao = ""
        val senha_padrao = ""

        val btn = findViewById<Button>(R.id.btn_botao_login)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intentNotificacao = Intent(this, ConsultaComandaActivity::class.java)
        val intent = Intent(this, TelaInicialActivity::class.java)
        btn.setOnClickListener {

            val nome = campo_usuario.text.toString()
            val senha = campo_senha.text.toString()

            if (nome != "" || senha != "") {
                Toast.makeText(this, "Preencher todos os campos!!!", Toast.LENGTH_LONG).show()
                campo_usuario.requestFocus()
            } else {
                if (nome != nome_padrao || senha != senha_padrao) {
                    Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)/*volta pra activity de login*/
                } else {
                    Toast.makeText(this, "Validado", Toast.LENGTH_LONG).show()
                    val pendingIntent = PendingIntent.getActivity(this, 0,
                            intentNotificacao, PendingIntent.FLAG_CANCEL_CURRENT)
                    val view = RemoteViews(packageName,
                        R.layout.activity_tela_inicial
                    )
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        notificationChannel = NotificationChannel(
                                channelID, desc,
                                NotificationManager.IMPORTANCE_HIGH
                        )

                        notificationChannel.enableLights(true)
                        notificationChannel.lightColor = Color.GRAY
                        notificationChannel.enableVibration(true)
                        notificationManager.createNotificationChannel(notificationChannel)

                        builder = Notification.Builder(this)
                                .setContentTitle("NOTIFICAÇÃO.:")
                                .setContentText("CLIQUE AQUI E VERIFIQUE AS COMANDAS EM ABERTO")
                                .setSmallIcon(R.drawable.ic_configuracoes_black)
                                .setChannelId(channelID)
                                .setLargeIcon(BitmapFactory.decodeResource(this.resources,
                                    R.drawable.ic_launcher_background
                                ))
                                .setContentIntent(pendingIntent)
                        startActivity(intent)
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            builder = Notification.Builder(this)
                                    .setContentTitle("NOTIFICAÇÃO.:")
                                    .setContentText("AQUI VAI A NOTIFICAÇÃO")
                                    .setSmallIcon(R.drawable.ic_configuracoes_black)
                                    .setChannelId(channelID)
                                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,
                                        R.drawable.ic_launcher_background
                                    )
                                    )
                                    .setContentIntent(pendingIntent)
                            startActivity(intentNotificacao)
                        }
/*      A linha de código abaixo serve para setar uma imagem para o botão de login
        image_login.setImageResource(R.drawable.imagem_login)
*/
                    }
                    notificationManager.notify(1234, builder.build())

                }
            }
        }
    }
}
