package com.example.bibliounifornew

import android.app.Activity
import android.content.Intent
import android.widget.ImageView

object NavigationUtils {

    // --- NAVEGAÇÃO DO USUÁRIO (RF09, RF12, etc.) ---

    fun setupBottomNavigation(activity: Activity) {
        // 1. Casa -> RF09
        activity.findViewById<ImageView>(R.id.navHome)?.setOnClickListener {
            if (activity !is TelaRF09DashboardUsuario) {
                activity.startActivity(Intent(activity, TelaRF09DashboardUsuario::class.java))
            }
        }
        // 2. Tenda -> RF16
        activity.findViewById<ImageView>(R.id.navLivraria)?.setOnClickListener {
            if (activity !is TelaRF16MinhaLivrariaActivity) {
                activity.startActivity(Intent(activity, TelaRF16MinhaLivrariaActivity::class.java))
            }
        }
        // 3. Lupa -> RF12
        activity.findViewById<ImageView>(R.id.navSearch)?.setOnClickListener {
            if (activity !is TelaRF12TelaDePesquisa) {
                activity.startActivity(Intent(activity, TelaRF12TelaDePesquisa::class.java))
            }
        }
        // 4. Coração/Desejos -> RF17
        val navDesejos = activity.findViewById<ImageView>(R.id.navDesejos) ?: activity.findViewById<ImageView>(R.id.navFavorites)
        navDesejos?.setOnClickListener {
            if (activity !is TelaRF17ListaDesejosActivity) {
                activity.startActivity(Intent(activity, TelaRF17ListaDesejosActivity::class.java))
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
            if (activity !is TelaRF18) {
                activity.startActivity(Intent(activity, TelaRF18::class.java))
            }
        }
    }

    fun setupTopBar(activity: Activity) {
        // Sino -> Notificações (RF21)
        activity.findViewById<ImageView>(R.id.btnNotificacao)?.setOnClickListener {
            if (activity !is TelaRF21Notificacoes) {
                activity.startActivity(Intent(activity, TelaRF21Notificacoes::class.java))
            }
        }
        // Engrenagem -> Configurações (RF10)
        activity.findViewById<ImageView>(R.id.btnConfig)?.setOnClickListener {
            if (activity !is TelaRF10Configuracao) {
                activity.startActivity(Intent(activity, TelaRF10Configuracao::class.java))
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
            if (activity !is TelaRF30DashboardADM) {
                activity.startActivity(Intent(activity, TelaRF30DashboardADM::class.java))
            }
        }

        navFinanceiro?.setOnClickListener {
            if (activity !is TelaRF36FinanceiroADM) {
                activity.startActivity(Intent(activity, TelaRF36FinanceiroADM::class.java))
            }
        }

        navSolicitacoes?.setOnClickListener {
            if (activity !is TelaRF33VerificarMidia && activity !is TelaRF33Solicitacoes) {
                activity.startActivity(Intent(activity, TelaRF33VerificarMidia::class.java))
            }
        }

        navLivrosADM?.setOnClickListener {
            if (activity !is TelaRF34LivrosCRUD && activity !is TelaRF42VerificarMidia) {
                activity.startActivity(Intent(activity, TelaRF34LivrosCRUD::class.java))
            }
        }

        navUsuarios?.setOnClickListener {
            if (activity !is TelaRF31GerenciamentoDeUsuarios) {
                activity.startActivity(Intent(activity, TelaRF31GerenciamentoDeUsuarios::class.java))
            }
        }

        highlightActiveAdminIcon(activity)
    }

    fun setupAdminTopBar(activity: Activity) {
        activity.findViewById<ImageView>(R.id.btnConfigAdm)?.setOnClickListener {
            if (activity !is TelaRF40ConfigADM) {
                activity.startActivity(Intent(activity, TelaRF40ConfigADM::class.java))
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
            is TelaRF30DashboardADM -> navHome?.setColorFilter(activeColor)
            is TelaRF36FinanceiroADM -> navFin?.setColorFilter(activeColor)
            is TelaRF33VerificarMidia, is TelaRF33Solicitacoes -> navSol?.setColorFilter(activeColor)
            is TelaRF42VerificarMidia, is TelaRF34LivrosCRUD, is TelaRF35CadastroDeLivros,
            is TelaRF35_3InfosAdicionais, is TelaRF35_4Versoes, is TelaRF38ListaAlugueisADM,
            is TelaRF39InfoLivroADM, is TelaAlugadosUsuarioADM -> navMidia?.setColorFilter(activeColor)
            is TelaRF31GerenciamentoDeUsuarios, is TelaRF32UsuariosParaADM,
            is TelaRF37ConfirmarCadastroADM -> navUser?.setColorFilter(activeColor)
        }
    }
}
