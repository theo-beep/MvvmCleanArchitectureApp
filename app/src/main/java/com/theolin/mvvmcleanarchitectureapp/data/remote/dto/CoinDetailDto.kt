package com.theolin.mvvmcleanarchitectureapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CoinDetailDto(
    @SerializedName("description") var description: String,
    @SerializedName("development_status") var developmentStatus: String,
    @SerializedName("first_data_at") var firstDataAt: String,
    @SerializedName("hardware_wallet") var hardwareWallet: Boolean,
    @SerializedName("hash_algorithm") var hashAlgorithm: String,
    @SerializedName("id") var id: String,
    @SerializedName("is_active") var isActive: Boolean,
    @SerializedName("is_new") var isNew: Boolean,
    @SerializedName("last_data_at") var lastDataAt: String,
    @SerializedName("links") var links: Links,
    @SerializedName("links_extended") var linksExtended: List<LinksExtended>,
    @SerializedName("logo") var logo: String,
    @SerializedName("message") var message: String,
    @SerializedName("name") var name: String,
    @SerializedName("open_source") var openSource: Boolean,
    @SerializedName("org_structure") var orgStructure: String,
    @SerializedName("proof_type") var proofType: String,
    @SerializedName("rank") var rank: Int,
    @SerializedName("started_at") var startedAt: String,
    @SerializedName("symbol") var symbol: String,
    @SerializedName("tags") var tags: List<Tag>,
    @SerializedName("team") var team: List<TeamMember>,
    @SerializedName("type") var type: String,
    @SerializedName("whitepaper") var whitepaper: Whitepaper
) {
    @Keep
    data class Links(
        @SerializedName("explorer") var explorer: List<String>,
        @SerializedName("facebook") var facebook: List<String>,
        @SerializedName("reddit") var reddit: List<String>,
        @SerializedName("source_code") var sourceCode: List<String>,
        @SerializedName("website") var website: List<String>,
        @SerializedName("youtube") var youtube: List<String>
    )

    @Keep
    data class LinksExtended(
        @SerializedName("stats") var stats: Stats,
        @SerializedName("type") var type: String,
        @SerializedName("url") var url: String
    ) {
        @Keep
        data class Stats(
            @SerializedName("contributors") var contributors: Int,
            @SerializedName("followers") var followers: Int,
            @SerializedName("stars") var stars: Int,
            @SerializedName("subscribers") var subscribers: Int
        )
    }

    @Keep
    data class Tag(
        @SerializedName("coin_counter") var coinCounter: Int,
        @SerializedName("ico_counter") var icoCounter: Int,
        @SerializedName("id") var id: String,
        @SerializedName("name") var name: String
    )

    @Keep
    data class TeamMember(
        @SerializedName("id") var id: String,
        @SerializedName("name") var name: String,
        @SerializedName("position") var position: String
    )

    @Keep
    data class Whitepaper(
        @SerializedName("link") var link: String,
        @SerializedName("thumbnail") var thumbnail: String
    )
}