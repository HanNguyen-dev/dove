#!/bin/sh

dotnet new sln --name Sapiens
dotnet new webapi --name Sapiens.Api
dotnet new classlib --name Sapiens.Domain
dotnet new classlib --name Sapiens.DataAccess
dotnet new xunit --name Sapiens.UnitTest

dotnet add Sapiens.Api/Sapiens.Api.csproj reference Sapiens.Domain/Sapiens.Domain.csproj
dotnet add Sapiens.DataAccess/Sapiens.DataAccess.csproj reference Sapiens.Domain/Sapiens.Domain.csproj
dotnet add Sapiens.Api/Sapiens.Api.csproj reference Sapiens.DataAccess/Sapiens.DataAccess.csproj

dotnet add Sapiens.DataAccess/Sapiens.DataAccess.csproj package AWSSDK.Core
dotnet add Sapiens.DataAccess/Sapiens.DataAccess.csproj package AWSSDK.DynamoDBv2

dotnet add Sapiens.UnitTest/Sapiens.UnitTest.csproj package moq
dotnet add Sapiens.UnitTest/Sapiens.UnitTest.csproj package coverlet.msbuild
dotnet add Sapiens.UnitTest/Sapiens.UnitTest.csproj package coverlet

dotnet sln add **/*.csproj