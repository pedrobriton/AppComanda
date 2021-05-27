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
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RemoteViews
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*
import scarlet.machado.lmsapp.R

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelID = "Pedr"
    private val desc = "Notificação.:"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "TELA PRINCIPAL"
        configuraMenuLateral()

        // a linha abaixo dd a
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // intent para a notoficação
        val intentNotificacao = Intent(this, ConsultaComandaActivity::class.java)

        val btn_abrir_comanda = findViewById<Button>(R.id.btn_abrir_comanda)
        val btn_consultar_comanda = findViewById<Button>(R.id.btn_consultar_comanda)
        val btn_cardapio = findViewById<Button>(R.id.btn_abrir_cardapio)



        btn_abrir_comanda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AbrirComandaActivity::class.java)
            startActivity(intent)
        })

        btn_consultar_comanda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ConsultaComandaActivity::class.java)
            startActivity(intent)
        })

        btn_cardapio.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AbrirCardapioActivity::class.java)
            startActivity(intent)
        })


        // o trecho abaixo pega o nome do usuario digitado e mostra na tela de boas vindas
        // TOTALMENTE OPCIONAL, tirei mas deixei aqui caso alguem queira mudar
     /*   var params = intent.extras
        val nome: String? = params?.getString("nome")
        Toast.makeText(
            this, "Nome do usuário $nome",
            Toast.LENGTH_LONG).show()
        var numero = params?.getInt("numero")*/

/*        setSupportActionBar(toolbar)*/

       // recycler_produtos?.layoutManager = LinearLayoutManager(this)
    }
    //        supportActionBar?.setDisplayHomeAsUpEnabled // seta para voltar

       /* val btn_cardapio = findViewById<Button>(R.id.abrir_cardapio)
        val btn_comanda = findViewById<Button>(R.id.comandas)
        val btn_pedido = findViewById<Button>(R.id.anotar_pedido)


        *//*CONFIGURANDO OS BOTÕES *//*
        clickBotoesPrincipal(btn_cardapio, btn_pedido, btn_comanda)

    }
        // A IMPLEMENTAÇÃO ABAIXO FOI NO INICIO DO PROJETO
        // HOUVE MODIFICAÇÕES DURANTE O DESENVOLVINENTO
        // RESOLVI DEIXAR PARA FINS DE APRENDIZADO
        btn_cardapio.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ProdutosActivity::class.java) *//*enviar para tela de cadastro*//*
            Toast.makeText(this, " NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
        btn_pedido.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CadastrarActivity::class.java)*//* enviar para tela de cadastro*//*
            Toast.makeText(this, "REDIRECIONANDO PARA PAGINA DE PEDIDOS",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
        btn_comanda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AcoesBtnActivity::class.java) *//*enviar para tela de cadastro*//*
            Toast.makeText(this, " NAO IMPLEMENTADO",
                    Toast.LENGTH_LONG).show()
            startActivity(intent)
        })
    }*/
        /*
        // O trecho abaixo lista produtos na tela inicial
        // totalmente desnecessário mas está ai caso eu esqueça como implementar
        private var produtos = listOf<Produto>()
        override fun onResume() {
            super.onResume()
            produtos = ProdutoService.getProdutos()
            recycler_produtos?.adapter = ProdutoAdapter(produtos) { onClickProduto(it)
            }
        }


        fun onClickProduto(produto: Produto){
            Toast.makeText(this, "Clicou produto ${produto.nome}", Toast.LENGTH_LONG).show()
        }
*/

        // configurando o menu lateral
        private fun configuraMenuLateral(){
            var toogle = ActionBarDrawerToggle(
                this,
                layout_menu_lateral,
                toolbar,
                R.string.nav_open,
                R.string.nav_close
            )
            layout_menu_lateral.addDrawerListener(toogle)
            toogle.syncState()

            nav_menu_lateral.setNavigationItemSelectedListener(this)
        }

        /*Inflando botoes do menu e colocando ações*/
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.nav_comanda -> {
                    val intent = Intent(this, AbrirComandaActivity::class.java)
                    startActivity(intent)

                    // o trecho abaixo testa se o botão funciona, emitidindo um alerta na tela
                    /*val builder = AlertDialog.Builder(this)
                    builder.setNeutralButton("OK", null)
                    builder.setTitle("Alerta")
                    val dialog = builder.create()
                    dialog.show()*/

                }

                R.id.nav_cardapio -> {
                    Toast.makeText(this, "Clicou em Cardápio", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, AbrirCardapioActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_pedido -> {
                    Toast.makeText(this, "Clicou em Anotar Pedido", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, CadastrarActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_config -> {
                    Toast.makeText(this, "Clicou em Configurar", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, ConfigurarActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_sair -> {
                    Toast.makeText(this, "Clicou em Sair", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

            }
            layout_menu_lateral.closeDrawer((GravityCompat.START))/*ao clicar em um item do menu, ele recolhe*/
            return true
        }
        /*INFLANDO O MENU*/
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
        }
        /*COLOCANDO OPÇÕES NO MENU*/
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            val id = item.itemId

            if(id == R.id.action_buscar){
                Toast.makeText(this, "Abrir cardápio",
                    Toast.LENGTH_LONG).show()
                val intent = Intent(this, AbrirCardapioActivity::class.java)
                startActivity(intent)
            }
            else if( id == R.id.action_add){
                Toast.makeText(this, "Botão de adicionar clicado",
                    Toast.LENGTH_LONG).show()
                val intent = Intent(this, CadastrarActivity::class.java) /*enviar para tela de cadastro*/
                startActivity(intent)

            }
            else if (id == R.id.action_sair){
                Toast.makeText(this, "Botão de sair clicado",
                    Toast.LENGTH_LONG).show()
                finish()
                val intent = Intent(this, MainActivity::class.java)/* enviar para tela de cadastro*/

                startActivity(intent)


            }
            else if (id == R.id.action_atualizar){
                Toast.makeText(this, "IMPLEMENTADO UMA NOTIFICAÇÃO QUANDO O USUÁRIO ATUALIZAR O APP",
                    Toast.LENGTH_LONG).show()

                val intentNotificacao = Intent(this, TelaInicialActivity::class.java)
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
                            .setContentText("CLIQUE AQUI E VERIFIQUE A NOTIFICAÇÃO")
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

                }
                notificationManager.notify(1234, builder.build())
                   }else if(id == R.id.action_confg){
                            Toast.makeText(this, "BOTÃO DE CONFIGURAR CLICADO",
                                Toast.LENGTH_LONG).show()
                            val intent = Intent(this, ConfigurarActivity::class.java) /*enviar para tela de cadastro*/
                            startActivity(intent)

                        }else if(id == android.R.id.home){
                            finish()
                        }

                        return super.onOptionsItemSelected(item)

        }
    }