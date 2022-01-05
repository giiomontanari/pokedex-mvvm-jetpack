package com.example.pokedexjetpack.data.repository

import com.example.pokedexjetpack.data.remote.PokemonApi
import com.example.pokedexjetpack.data.remote.response.Pokemon
import com.example.pokedexjetpack.data.remote.response.PokemonList
import com.example.pokedexjetpack.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Ocorreu um problema.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String) : Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("Ocorreu um problema.")
        }
        return Resource.Success(response)
    }
}