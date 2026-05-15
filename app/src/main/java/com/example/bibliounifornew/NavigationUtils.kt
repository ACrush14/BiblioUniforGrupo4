package com.example.bibliounifornew

import android.app.Activity
import android.content.Intent
import android.widget.ImageView
import com.example.bibliounifornew.adm.TelaRF28DashboardADM
import com.example.bibliounifornew.adm.TelaRF29GerenciamentoDeUsuarios
import com.example.bibliounifornew.adm.TelaRF30UsuariosParaADM
import com.example.bibliounifornew.adm.TelaRF31Solicitacoes
import com.example.bibliounifornew.adm.TelaRF32LivrosCRUD
import com.example.bibliounifornew.adm.TelaRF33CadastroDeLivros
import com.example.bibliounifornew.adm.TelaRF34FinanceiroADM
import com.example.bibliounifornew.adm.TelaRF33InfosAdicionais
import com.example.bibliounifornew.adm.TelaRF33Versoes
import com.example.bibliounifornew.adm.TelaRF35ConfirmarCadastroADM
import com.example.bibliounifornew.adm.TelaRF36ListaAlugueisADM
import com.example.bibliounifornew.adm.TelaRF37InfoLivroADM
import com.example.bibliounifornew.adm.TelaRF38ConfigADM
import com.example.bibliounifornew.usuario.TelaRF08DashboardUsuario
import com.example.bibliounifornew.usuario.TelaRF09Configuracao
import com.example.bibliounifornew.usuario.TelaRF11TelaDePesquisa
import com.example.bibliounifornew.usuario.TelaRF15MinhaLivrariaActivity
import com.example.bibliounifornew.usuario.TelaRF16ListaDesejosActivity
import com.example.bibliounifornew.usuario.TelaRF17Amigos
import com.example.bibliounifornew.usuario.TelaRF20Notificacoes

object NavigationUtils {

    // --- NAVEGAÇÃO DO USUÁRIO (RF09, RF12, etc.) ---

    fun setupBottomNavigation(activity: Activity) {
        // 1. Casa -> RF09
        activity.findViewById<ImageView>(R.id.navHome)?.setOnClickListener {
            if (activity !is TelaRF08DashboardUsuario) {
                activity.startActivity(Intent(activity, TelaRF08DashboardUsuario::class.java))
            }
        }
        // 2. Tenda -> RF16
        activity.findViewById<ImageView>(R.id.navLivraria)?.setOnClickListener {
            if (activity !is TelaRF15MinhaLivrariaActivity) {
                activity.startActivity(Intent(activity, TelaRF15MinhaLivrariaActivity::class.java))
            }
        }
        // 3. Lupa -> RF12
        activity.findViewById<ImageView>(R.id.navSearch)?.setOnClickListener {
            if (activity !is TelaRF11TelaDePesquisa) {
                activity.startActivity(Intent(activity, TelaRF11TelaDePesquisa::class.java))
            }
        }
        // 4. Coração/Desejos -> RF17
        val navDesejos = activity.findViewById<ImageView>(R.id.navDesejos) ?: activity.findViewById<ImageView>(R.id.navFavorites)
        navDesejos?.setOnClickListener {
            if (activity !is TelaRF16ListaDesejosActivity) {
                activity.startActivity(Intent(activity, TelaRF16ListaDesejosActivity::class.java))
            }
        }
        // 5. Livro -> RF19
        val navAluguel = activity.findViewById<ImageView>(R.id.navAluguel) ?: activity.findViewById<ImageView>(R.id.navRentals)
        navAluguel?.setOnClickListener {
            if (activity !is TelaRF19) {
                activity.startActivity(Intent(activity, TelaRF19::class.java))
            }
        }
        // 6. Pessoa -> RF18
        val navAmigos = activity.findViewById<ImageView>(R.id.navAmigos) ?: activity.findViewById<ImageView>(R.id.navFriends)
        navAmigos?.setOnClickListener {
            if (activity !is TelaRF17Amigos) {
                activity.startActivity(Intent(activity, TelaRF17Amigos::class.java))
            }
        }
    }

    fun setupTopBar(activity: Activity) {
        // Sino -> Notificações (RF21)
        activity.findViewById<ImageView>(R.id.btnNotificacao)?.setOnClickListener {
            if (activity !is TelaRF20Notificacoes) {
                activity.startActivity(Intent(activity, TelaRF20Notificacoes::class.java))
            }
        }
        // Engrenagem -> Configurações (RF10)
        activity.findViewById<ImageView>(R.id.btnConfig)?.setOnClickListener {
            if (activity !is TelaRF09Configuracao) {
                activity.startActivity(Intent(activity, TelaRF09Configuracao::class.java))
            }
        }
    }

    // --- NAVEGAÇÃO DO ADMINISTRADOR (RF30 a RF42) ---

    fun setupAdminNavigation(activity: Activity) {
        setupAdminBottomNavigation(activity)
        setupAdminTopBar(activity)
    }

    fun setupAdminBottomNavigation(activity: Activity) {
        val navDashboard = activity.findViewById<ImageView>(R.id.navHomeAdm) ?: activity.findViewById<ImageView>(R.id.navDashboard)
        val navFinanceiro = activity.findViewById<ImageView>(R.id.navFinanceiroAdm) ?: activity.findViewById<ImageView>(R.id.navFinanceiro)
        val navSolicitacoes = activity.findViewById<ImageView>(R.id.navSolicitacoesAdm) ?: activity.findViewById<ImageView>(R.id.navSolicitacoes)
        val navLivrosADM = activity.findViewById<ImageView>(R.id.navVerificarMidiaAdm) ?: activity.findViewById<ImageView>(R.id.navLivrosADM)
        val navUsuarios = activity.findViewById<ImageView>(R.id.navGerenciarUsuariosAdm) ?: activity.findViewById<ImageView>(R.id.navUsuarios)

        navDashboard?.setOnClickListener {
            if (activity !is TelaRF28DashboardADM) {
                activity.startActivity(Intent(activity, TelaRF28DashboardADM::class.java))
            }
        }

        navFinanceiro?.setOnClickListener {
            if (activity !is TelaRF34FinanceiroADM) {
                activity.startActivity(Intent(activity, TelaRF34FinanceiroADM::class.java))
            }
        }

        navSolicitacoes?.setOnClickListener {
            if (activity !is TelaRF33VerificarMidia && activity !is TelaRF31Solicitacoes) {
                activity.startActivity(Intent(activity, TelaRF33VerificarMidia::class.java))
            }
        }

        navLivrosADM?.setOnClickListener {
            if (activity !is TelaRF32LivrosCRUD && activity !is TelaRF42VerificarMidia) {
                activity.startActivity(Intent(activity, TelaRF32LivrosCRUD::class.java))
            }
        }

        navUsuarios?.setOnClickListener {
            if (activity !is TelaRF29GerenciamentoDeUsuarios) {
                activity.startActivity(Intent(activity, TelaRF29GerenciamentoDeUsuarios::class.java))
            }
        }

        highlightActiveAdminIcon(activity)
    }

    fun setupAdminTopBar(activity: Activity) {
        activity.findViewById<ImageView>(R.id.btnConfigAdm)?.setOnClickListener {
            if (activity !is TelaRF38ConfigADM) {
                activity.startActivity(Intent(activity, TelaRF38ConfigADM::class.java))
            }
        }
    }

    private fun highlightActiveAdminIcon(activity: Activity) {
        val activeColor = 0xFF6EC1C3.toInt()
        val inactiveColor = 0xFFA0A0A0.toInt()

        val navHome = activity.findViewById<ImageView>(R.id.navHomeAdm) ?: activity.findViewById<ImageView>(R.id.navDashboard)
        val navFin = activity.findViewById<ImageView>(R.id.navFinanceiroAdm) ?: activity.findViewById<ImageView>(R.id.navFinanceiro)
        val navSol = activity.findViewById<ImageView>(R.id.navSolicitacoesAdm) ?: activity.findViewById<ImageView>(R.id.navSolicitacoes)
        val navMidia = activity.findViewById<ImageView>(R.id.navVerificarMidiaAdm) ?: activity.findViewById<ImageView>(R.id.navLivrosADM)
        val navUser = activity.findViewById<ImageView>(R.id.navGerenciarUsuariosAdm) ?: activity.findViewById<ImageView>(R.id.navUsuarios)

        listOf(navHome, navFin, navSol, navMidia, navUser).forEach { it?.setColorFilter(inactiveColor) }

        when (activity) {
            is TelaRF28DashboardADM -> navHome?.setColorFilter(activeColor)
            is TelaRF34FinanceiroADM -> navFin?.setColorFilter(activeColor)
            is TelaRF33VerificarMidia, is TelaRF31Solicitacoes -> navSol?.setColorFilter(activeColor)
            is TelaRF42VerificarMidia, is TelaRF32LivrosCRUD, is TelaRF33CadastroDeLivros,
            is TelaRF33InfosAdicionais, is TelaRF33Versoes, is TelaRF36ListaAlugueisADM,
            is TelaRF37InfoLivroADM, is TelaAlugadosUsuarioADM -> navMidia?.setColorFilter(activeColor)
            is TelaRF29GerenciamentoDeUsuarios, is TelaRF30UsuariosParaADM,
            is TelaRF35ConfirmarCadastroADM -> navUser?.setColorFilter(activeColor)
        }
    }
}
