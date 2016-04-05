package com.fortysevendeg.github4s.api

import com.fortysevendeg.github4s.GithubTypes._
import com.fortysevendeg.github4s.free.domain.{Commit, Repository, Collaborator}
import com.fortysevendeg.github4s.{GithubConfig, HttpClient}


object Repos {

  import io.circe.generic.auto._

  protected val httpClient = new HttpClient()

  def get(owner: String, repo: String)(implicit C : GithubConfig): GHResponse[Repository] =
    httpClient.get[Repository](s"repos/$owner/$repo")

  def listCommits(
      owner: String,
      repo: String,
      sha: Option[String] = None,
      path: Option[String] = None,
      author: Option[String] = None,
      since: Option[String] = None,
      until: Option[String] = None)(implicit C : GithubConfig): GHResponse[List[Commit]] =
    httpClient.get[List[Commit]](s"repos/$owner/$repo/commits", Map("path"->"site/build.sbt"))

}